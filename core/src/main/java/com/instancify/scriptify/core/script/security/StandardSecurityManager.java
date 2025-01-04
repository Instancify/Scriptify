package com.instancify.scriptify.core.script.security;

import com.instancify.scriptify.api.script.security.ScriptSecurityManager;
import com.instancify.scriptify.api.script.security.exclude.SecurityExclude;

import java.util.HashSet;
import java.util.Set;

public class StandardSecurityManager implements ScriptSecurityManager {

    private boolean securityMode;
    private final Set<SecurityExclude> excludes = new HashSet<>();

    @Override
    public boolean getSecurityMode() {
        return securityMode;
    }

    @Override
    public void setSecurityMode(boolean securityMode) {
        this.securityMode = securityMode;
    }

    @Override
    public Set<SecurityExclude> getExcludes() {
        return excludes;
    }

    @Override
    public void addExclude(SecurityExclude exclude) {
        excludes.add(exclude);
    }

    @Override
    public void removeExclude(SecurityExclude exclude) {
        excludes.remove(exclude);
    }
}
