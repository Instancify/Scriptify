package com.instancify.scriptify.api.script.security.exclude;

public class PathSecurityExclude implements SecurityExclude {

    private final String value;

    public PathSecurityExclude(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean isExcluded(String value) {
        return this.getValue().startsWith(value);
    }
}
