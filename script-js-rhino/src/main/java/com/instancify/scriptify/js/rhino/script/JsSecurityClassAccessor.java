package com.instancify.scriptify.js.rhino.script;

import com.instancify.scriptify.api.script.security.SecurityClassAccessor;
import com.instancify.scriptify.api.script.security.exclude.ClassSecurityExclude;
import com.instancify.scriptify.api.script.security.exclude.PackageSecurityExclude;
import com.instancify.scriptify.api.script.security.exclude.SecurityExclude;
import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.EcmaError;

import java.util.HashSet;
import java.util.Set;

public class JsSecurityClassAccessor implements ClassShutter, SecurityClassAccessor {

    private final Set<SecurityExclude> excludes;
    private final Set<String> allowedClasses;
    private final Set<String> allowedPackages;

    public JsSecurityClassAccessor(Set<SecurityExclude> excludes) {
        this.excludes = excludes;
        this.allowedClasses = new HashSet<>();
        this.allowedPackages = new HashSet<>();

        for (SecurityExclude exclude : excludes) {
            if (exclude instanceof ClassSecurityExclude classExclude) {
                allowedClasses.add(classExclude.getValue());
            } else if (exclude instanceof PackageSecurityExclude packageExclude) {
                allowedPackages.add(packageExclude.getValue());
            }
        }

        this.allowedClasses.add(EcmaError.class.getName());
    }

    @Override
    public Set<SecurityExclude> getExcludes() {
        return excludes;
    }

    @Override
    public boolean visibleToScripts(String className) {
        if (this.allowedClasses.contains(className)) {
            return true;
        }
        for (String exclude : this.allowedPackages) {
            if (className.startsWith(exclude)) {
                return true;
            }
        }
        return false;
    }
}
