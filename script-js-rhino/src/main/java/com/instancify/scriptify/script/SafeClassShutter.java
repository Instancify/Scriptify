package com.instancify.scriptify.script;

import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.EcmaError;

import java.util.HashSet;
import java.util.Set;

public class SafeClassShutter implements ClassShutter {
    public final Set<String> allowedClasses;

    @Override
    public boolean visibleToScripts(final String fullClassName) {
        boolean _startsWith = fullClassName.startsWith("adapter");
        if (_startsWith) {
            return true;
        }
        return this.allowedClasses.contains(fullClassName);
    }

    public SafeClassShutter() {
        HashSet<String> _hashSet = new HashSet<String>();
        this.allowedClasses = _hashSet;
        this.allowedClasses.add(EcmaError.class.getName());
    }
}
