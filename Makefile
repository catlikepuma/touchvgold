# The simplest way to compile TouchVG on MinGW, Cygwin, Linux or Mac OS X is:
#
# 1. `cd' to the directory containing the file of 'Makefile'.
#
# 2. Type `make and' to compile the swig projects for Android.
#    The program binaries files are outputed to './build/java'.
# 
# 3. You can remove the program object files from the source code
#    directory by typing `make java.clean'.
#
# Readme about variables: https://github.com/rhcad/x3py/wiki/MakeVars
#

SUBDIRS         =$(subst /,,$(dir $(wildcard */)))
CLEANDIRS       =$(addsuffix .clean, $(SUBDIRS))
INSTALLDIRS     =$(addsuffix .install, $(SUBDIRS))
SWIGS           =python perl5 java csharp ruby php lua r
CLEANSWIGS      =$(addsuffix .clean, $(SWIGS))
CLEANALLSWIGS   =$(addsuffix .cleanall, $(SWIGS))

.PHONY:     $(SUBDIRS) $(SWIGS) clean install touch and
all:        $(SUBDIRS)
clean:      $(CLEANDIRS)
install:    $(INSTALLDIRS)

$(SUBDIRS):
	@! test -e $@/Makefile || $(MAKE) -C $@

$(CLEANDIRS) $(INSTALLDIRS):
	@ ! test -e $(basename $@)/Makefile || \
	$(MAKE) -C $(basename $@) $(subst .,,$(suffix $@))

$(SWIGS):
	@test -d build || mkdir build
	@export SWIG_TYPE=$@; $(MAKE) -C core swig

$(CLEANSWIGS):
	@export SWIG_TYPE=$(basename $@); \
	export clean=1; $(MAKE) -C core clean

$(CLEANALLSWIGS):
	@export SWIG_TYPE=$(basename $@); export cleanall=1; \
	export clean=1; $(MAKE) -C core clean

touch:
	@export touch=1; $(MAKE) clean

and:
	@cd core/src/skiaview; \
	    test -d ._java || mkdir ._java; \
	    test -d ._java/touchvg || mkdir ._java/touchvg; \
	    test -d ._java/touchvg/skiaview || mkdir -v ._java/touchvg/skiaview; \
	    rm -rf ._java/*.* ._java/touchvg/skiaview/*.*; \
	swig -c++ -java -package touchvg.skiaview \
	    -outdir ._java/touchvg/skiaview -o skiaview_java_wrap.cxx \
	    -I../../../core/include/geom -I../../../core/include/graph \
	    -I../../../core/include/shape -I../../../core/include/skiaview \
	    -I../../../core/src/skiaview -I"$(JAVA_INCLUDE)" skiaview.i;
	@cd core/src/skiaview/._java/touchvg/skiaview; "javac" *.java;
	@cd core/src/skiaview/._java; "jar" cfv skiaview.jar touchvg/skiaview/*.class;
	@test -d android/hello/libs || mkdir android/hello/libs
	@cp -v core/src/skiaview/._java/skiaview.jar android/hello/libs
	@cp -v core/src/skiaview/skiaview_java_wrap.cxx android/hello/jni/skiaview_java_wrap.cpp
