#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Run "python makecc.py" to replace the source files' extension.
#

import os

def makecc(dir, extold, extnew):
    for fn in os.listdir(dir):
        sfile = os.path.join(dir, fn)
        if fn[0] != '.' and os.path.isdir(sfile):
            makecc(sfile, extold, extnew)
            continue
        if extold in fn:
            newfile = sfile.replace(extold, extnew)
            open(newfile, 'wb').write(open(sfile, 'rb').read())

if __name__=="__main__":
    makecc(os.path.abspath('../core'), '.cpp', '.cc')
    makecc(os.path.abspath('../core'), '.cxx', '.cc')
