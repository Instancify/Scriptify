package com.instancify.scriptify.script;

import com.instancify.scriptify.api.script.security.SecurityClassAccessor;
import org.graalvm.polyglot.PolyglotException;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class JsSecurityClassAccessor implements Predicate<String>, SecurityClassAccessor {

    private final Set<String> allowedClasses = new HashSet<>();

    public JsSecurityClassAccessor() {
        this.allowedClasses.add(PolyglotException.class.getName());
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
    public boolean test(String className) {
        return this.allowedClasses.contains(className);
    }
}
