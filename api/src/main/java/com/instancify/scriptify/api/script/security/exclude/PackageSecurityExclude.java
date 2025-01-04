package com.instancify.scriptify.api.script.security.exclude;

public class PackageSecurityExclude implements SecurityExclude {

    private final String value;

    public PackageSecurityExclude(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
