package com.instancify.scriptify.api.script.security.exclude;

public class ClassSecurityExclude implements SecurityExclude {

    private final Class<?> value;

    public ClassSecurityExclude(Class<?> value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.getName();
    }
}
