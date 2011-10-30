// GiViewController.mm
// Copyright (c) 2012, Zhang Yungui <rhcad@hotmail.com>
// License: LGPL, https://github.com/rhcad/graph2d

#import "GiViewController.h"
#include <Graph2d/mgshapest.h>
#include <list>
#import "GiCmdController.h"
#import "GiGraphView.h"

enum kGestureType {
    kGesturePinch,
    kGestureTwoPan,
    kGestureTwoTaps,
    kGestureTap,
};

@interface GiViewController(GestureRecognizer)

- (id<GiView>)gview;
- (id<GiMotionHandler>)motionView:(SEL)aSelector;
- (id<GiMotionHandler>)getCommand:(SEL)aSelector;
- (void)updateMagnifierCenter:(CGPoint)point;
- (void)convertFromMagnifier:(UIGestureRecognizer *)sender;

- (void)addGestureRecognizers;
- (void)twoFingersPinch:(UIPinchGestureRecognizer *)sender;
- (void)twoFingersPan:(UIPanGestureRecognizer *)sender;
- (void)oneFingerPan:(UIPanGestureRecognizer *)sender;
- (void)oneFingerTwoTaps:(UITapGestureRecognizer *)sender;
- (void)oneFingerOneTap:(UITapGestureRecognizer *)sender;

@end

@implementation GiViewController

@synthesize gestureRecognizerUsed = _gestureRecognizerUsed;
@synthesize lineWidth;
@synthesize lineColor;
@synthesize fillColor;
@synthesize lineAlpha;
@synthesize fillAlpha;
@synthesize lineStyle;
@synthesize commandName;
@synthesize shapes;

- (id)init
{
    self = [super init];
    if (self) {
        _magnifierView = Nil;
        _curView = Nil;
        _command = [[GiCommandController alloc]init:&_magnifierView];
        _shapesCreated = NULL;
        for (int i = 0; i < RECOGNIZER_COUNT; i++)
            _recognizers[i] = Nil;
        _gestureRecognizerUsed = YES;
    }
    return self;
}

- (void)viewDidLoad
{
    _curView = self.view;
    [[self gview] setDrawingDelegate:self];
    [self addGestureRecognizers];
}

- (void)dealloc
{
    [_command release];
    
    if (_shapesCreated) {
        ((MgShapes*)_shapesCreated)->release();
        _shapesCreated = NULL;
    }
    for (int i = 0; i < RECOGNIZER_COUNT; i++) {
        [_recognizers[i] release];
        _recognizers[i] = Nil;
    }
    [super dealloc];
}

- (UIView*)createGraphView:(CGRect)frame backgroundColor:(UIColor*)bkColor shapes:(void*)sp
{
    GiGraphView *aview = [[GiGraphView alloc] initWithFrame:frame];
    
    self.view = aview;
    _curView = aview;
    aview.backgroundColor = bkColor;
    [aview setDrawingDelegate:self];
    
    if (sp) {
        aview.shapes = (MgShapes*)sp;
    }
    else
    {
        aview.shapes = new MgShapesT<std::list<MgShape*> >;
        _shapesCreated = aview.shapes;
    }
    
    if (!_recognizers[0])
        [self addGestureRecognizers];
    
    [aview release];
    return self.view;
}

- (UIView*)createSubGraphView:(UIView*)parentView shapes:(void*)sp
{
    GiGraphView *aview = [[GiGraphView alloc] initWithFrame:parentView.bounds];
    
    self.view = aview;
    _curView = aview;
    aview.backgroundColor = [UIColor clearColor];
    aview.enableZoom = NO;
    
    [aview setDrawingDelegate:self];
    [parentView addSubview:aview];
    
    if (sp) {
        aview.shapes = (MgShapes*)sp;
    }
    else
    {
        aview.shapes = new MgShapesT<std::list<MgShape*> >;
        _shapesCreated = aview.shapes;
    }
    
    if (!_recognizers[0])
        [self addGestureRecognizers];
    
    [aview release];
    return self.view;
}

- (void)createMagnifierView:(UIView*)parentView frame:(CGRect)frame
{
    GiMagnifierView *aview = [[GiMagnifierView alloc] initWithFrame:frame graphView:[self gview]];
    _magnifierView = aview;
    aview.backgroundColor = [UIColor clearColor];
    
    [aview setDrawingDelegate:self];
    [parentView addSubview:aview];
    
    [aview release];
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
    [self clearCachedData];
}

- (void)clearCachedData
{
    [[self gview] getGraph]->clearCachedBitmap();
}

- (void*)shapes {
    return [[self gview] getShapes];
}

- (const char*)commandName {
    GiCommandController* cmd = (GiCommandController*)_command;
    return cmd.commandName;
}

- (void)setCommandName:(const char*)name {
    GiCommandController* cmd = (GiCommandController*)_command;
    cmd.commandName = name;
}

- (int)lineWidth {
    GiCommandController* cmd = (GiCommandController*)_command;
    return cmd.lineWidth;
}

- (void)setLineWidth:(int)w {
    GiCommandController* cmd = (GiCommandController*)_command;
    [cmd setLineWidth:w];
}

- (UIColor*)lineColor {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor c = cmd.lineColor;
    return [UIColor colorWithRed:c.r green:c.g blue:c.b alpha:1];
}

- (void)setLineColor:(UIColor*)c {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor color(giFromCGColor(c.CGColor));
    if (color.a > 0.01f && cmd.lineColor.a > 0)
        color.a = cmd.lineColor.a;
    [cmd setLineColor:color];
}

- (UIColor*)fillColor {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor c = cmd.fillColor;
    return [UIColor colorWithRed:c.r green:c.g blue:c.b alpha:1];
}

- (void)setFillColor:(UIColor*)c {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor color(giFromCGColor(c.CGColor));
    if (color.a > 0.01f && cmd.fillColor.a > 0)
        color.a = cmd.fillColor.a;
    [cmd setFillColor:color];
}

- (float)lineAlpha {
    GiCommandController* cmd = (GiCommandController*)_command;
    return cmd.lineColor.a / 255.0f;
}

- (void)setLineAlpha:(float)a {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor color(cmd.lineColor);
    color.a = mgRound(a * 255);
    [cmd setLineColor:color];
}

- (float)fillAlpha {
    GiCommandController* cmd = (GiCommandController*)_command;
    return cmd.fillColor.a / 255.0f;
}

- (void)setFillAlpha:(float)a {
    GiCommandController* cmd = (GiCommandController*)_command;
    GiColor color(cmd.fillColor);
    color.a = mgRound(a * 255);
    [cmd setFillColor:color];
}

- (int)lineStyle {
    GiCommandController* cmd = (GiCommandController*)_command;
    return cmd.lineStyle;
}

- (void)setLineStyle:(int)style {
    GiCommandController* cmd = (GiCommandController*)_command;
    [cmd setLineStyle:style];
}

#pragma mark - View motion

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
	return YES;     // supported orientations
}

- (void)willRotateToInterfaceOrientation:(UIInterfaceOrientation)orientation duration:(NSTimeInterval)duration
{
    [[self gview] setAnimating:YES];
    [super willRotateToInterfaceOrientation:orientation duration:duration];
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation
{
    [[self gview] setAnimating:NO];
    [super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    [self becomeFirstResponder];
}

- (void)viewDidDisappear:(BOOL)animated {
    [self resignFirstResponder];
    [super viewDidDisappear:animated];
}

- (BOOL)canBecomeFirstResponder {
    return YES;
}

- (void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event
{
    if (motion == UIEventSubtypeMotionShake) {
        [self undoMotion];
    }
}

- (void)undoMotion
{
    if (![[self getCommand:@selector(undoMotion)] undoMotion])
        [[self motionView:@selector(undoMotion)] undoMotion];
}

- (void)dynDraw:(id)sender
{
    GiGraphics* gs = NULL;
    
    if ([sender conformsToProtocol:@protocol(GiView)]) {
        id<GiView> aview = (id<GiView>)sender;
        gs = [aview getGraph];
    }
    else if (sender == _magnifierView) {
        GiMagnifierView *aview = (GiMagnifierView *)_magnifierView;
        gs = aview.graph;
    }
    
    if (gs && gs->isDrawing()) {
        [[self getCommand:@selector(dynDraw:)] dynDraw: gs];
    }
}

- (void)graphViewActivated:(UIView*)aview
{
    if (_curView != aview) {
        BOOL used = _gestureRecognizerUsed;
        [self setGestureRecognizerUsed:NO];
        _curView = aview;
        [self setGestureRecognizerUsed:used];
    }
}

@end

@implementation GiViewController(GestureRecognizer)

- (id<GiView>)gview
{
    assert([self.view conformsToProtocol:@protocol(GiView)]);
    return (id<GiView>)self.view;
}

- (id<GiMotionHandler>)motionView:(SEL)aSelector
{
    if ([self.view conformsToProtocol:@protocol(GiMotionHandler)]
        && [self.view respondsToSelector:aSelector]) {
        return (id<GiMotionHandler>)self.view;
    }
    return Nil;
}

- (id<GiMotionHandler>)getCommand:(SEL)aSelector
{
    return [_command respondsToSelector:aSelector] ?
        (id<GiMotionHandler>)_command : Nil;
}

- (void)addGestureRecognizers
{
    UIPinchGestureRecognizer *twoFingersPinch =
    [[UIPinchGestureRecognizer alloc] initWithTarget:self action:@selector(twoFingersPinch:)];
    _recognizers[kGesturePinch] = twoFingersPinch;
    
    UIPanGestureRecognizer *twoFingersPan =
    [[UIPanGestureRecognizer alloc] initWithTarget:self action:@selector(twoFingersPan:)];
    [twoFingersPan setMaximumNumberOfTouches:2];
    _recognizers[kGestureTwoPan] = twoFingersPan;
    
    UITapGestureRecognizer *oneFingerTwoTaps =
    [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(oneFingerTwoTaps:)];
    [oneFingerTwoTaps setNumberOfTapsRequired:2];
    _recognizers[kGestureTwoTaps] = oneFingerTwoTaps;
    
    UITapGestureRecognizer *oneFingerOneTap =
    [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(oneFingerOneTap:)];
    [oneFingerOneTap requireGestureRecognizerToFail:oneFingerTwoTaps];
    _recognizers[kGestureTap] = oneFingerOneTap;
    
    _touchCount = 0;
    if (_gestureRecognizerUsed) {
        for (int i = 0; i < RECOGNIZER_COUNT; i++)
            [self.view addGestureRecognizer:_recognizers[i]];
    }
}

- (void)setGestureRecognizerUsed:(BOOL)used
{
    if (_gestureRecognizerUsed) {
        for (int i = 0; i < RECOGNIZER_COUNT; i++)
            [_curView removeGestureRecognizer:_recognizers[i]];
    }
    _gestureRecognizerUsed = used;
    if (_gestureRecognizerUsed) {
        for (int i = 0; i < RECOGNIZER_COUNT; i++)
            [_curView addGestureRecognizer:_recognizers[i]];
    }
}

- (void)twoFingersPinch:(UIPinchGestureRecognizer *)sender
{
    [self convertFromMagnifier:sender];
    if (![[self getCommand:@selector(twoFingersPinch:)] twoFingersPinch:sender]
        && sender.view == self.view) {
        [[self motionView:@selector(twoFingersPinch:)] twoFingersPinch:sender];
    }
}

- (void)twoFingersPan:(UIPanGestureRecognizer *)sender
{
    if (sender.state == UIGestureRecognizerStateBegan) {
        _touchCount = [sender numberOfTouches];
    }
    if (1 == _touchCount) {
        [self oneFingerPan:sender];
    }
    else {
        [self convertFromMagnifier:sender];
        if (![[self getCommand:@selector(twoFingersPan:)] twoFingersPan:sender]) {
            [[self motionView:@selector(twoFingersPan:)] twoFingersPan:sender];
        }
    }
}

- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    UITouch *touch = [touches anyObject];
    CGPoint point = [touch locationInView:touch.view];
    
    GiCommandController* cmd = (GiCommandController*)_command;
    [cmd touchesBegan:point];
    
    [super touchesBegan:touches withEvent:event];
}

- (void)updateMagnifierCenter:(CGPoint)point
{
    GiCommandController* cmd = (GiCommandController*)_command;
    GiMagnifierView *zview = (GiMagnifierView *)_magnifierView;
    CGPoint ptzoom = [zview convertPoint:point fromView:self.view];
    
    if (CGRectContainsPoint(CGRectInset(zview.bounds, -20, -20), ptzoom)) {
        CGPoint cen;
        
        if (point.x < self.view.bounds.size.width / 2) {
            cen.x = self.view.bounds.size.width - zview.superview.frame.size.width / 2 - 10;
        }
        else {
            cen.x = zview.superview.frame.size.width / 2 + 10;
        }
        if (point.y < self.view.bounds.size.height / 2) {
            cen.y = self.view.bounds.size.height - zview.superview.frame.size.height / 2 - 10;
        }
        else {
            cen.y = zview.superview.frame.size.height / 2 + 10;
        }
        
        zview.superview.center = [zview.superview.superview convertPoint:cen fromView:self.view];
    }
    
    zview.centerW = [cmd getPointModel];
}

- (void)convertFromMagnifier:(UIGestureRecognizer *)sender
{
    GiCommandController* cmd = (GiCommandController*)_command;
    GiMagnifierView *zview = (GiMagnifierView *)_magnifierView;
    CGPoint point = [sender locationInView:sender.view];
    
    if (sender.view == _magnifierView) {
        Point2d ptw(Point2d(point.x, point.y) * zview.graph->xf().displayToWorld());
        ptw *= [[self gview]getXform]->worldToDisplay();
        
        point = CGPointMake(ptw.x, ptw.y);
        [cmd setTouchPoint:point view:self.view];
        
        if (sender.state == UIGestureRecognizerStateBegan)
            [cmd touchesBegan:point];
    }
    else {
        [cmd setTouchPoint:point view:sender.view];
    }
}

- (void)oneFingerPan:(UIPanGestureRecognizer *)sender
{
    [self convertFromMagnifier:sender];
    if (![[self getCommand:@selector(oneFingerPan:)] oneFingerPan:sender]
        && sender.view == self.view) {
        [[self motionView:@selector(oneFingerPan:)] oneFingerPan:sender];
    }
    if (_magnifierView && sender.view == self.view) {
        [self updateMagnifierCenter:[sender locationInView:sender.view]];
    }
}

- (void)oneFingerOneTap:(UITapGestureRecognizer *)sender
{
    [self convertFromMagnifier:sender];
    if (![[self getCommand:@selector(oneFingerOneTap:)] oneFingerOneTap:sender]
        && sender.view == self.view) {
        [[self motionView:@selector(oneFingerOneTap:)] oneFingerOneTap:sender];
    }
    if (_magnifierView && sender.view == self.view) {
        [self updateMagnifierCenter:[sender locationInView:sender.view]];
    }
}

- (void)oneFingerTwoTaps:(UITapGestureRecognizer *)sender
{
    [self convertFromMagnifier:sender];
    if (![[self getCommand:@selector(oneFingerTwoTaps:)] oneFingerTwoTaps:sender]
        && sender.view == self.view) {
        [[self motionView:@selector(oneFingerTwoTaps:)] oneFingerTwoTaps:sender];
    }
    if (_magnifierView && sender.view == self.view) {
        [self updateMagnifierCenter:[sender locationInView:sender.view]];
    }
}

@end
