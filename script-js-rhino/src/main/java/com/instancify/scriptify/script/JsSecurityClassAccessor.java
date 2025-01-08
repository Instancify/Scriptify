package com.instancify.scriptify.script;

import com.instancify.scriptify.api.script.security.SecurityClassAccessor;
import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.EcmaError;

import java.util.HashSet;
import java.util.Set;

public class JsSecurityClassAccessor implements ClassShutter, SecurityClassAccessor {

    private final Set<String> allowedClasses = new HashSet<>();

    public JsSecurityClassAccessor() {
        this.allowedClasses.add(EcmaError.class.getName());
    }

    @Override
    public Set<String> getAllowedClasses() {
        return allowedClasses;
    }

    @Override
    public void addAllowedClass(String allowedClass) {
        this.allowedClasses.add(allowedClass);
    }

    @Override
    public boolean visibleToScripts(String fullClassName) {
        return this.allowedClasses.contains(fullClassName);
    }
}
