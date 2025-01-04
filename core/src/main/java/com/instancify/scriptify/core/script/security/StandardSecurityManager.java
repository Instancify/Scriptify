package com.instancify.scriptify.core.script.security;

import com.instancify.scriptify.api.script.security.ScriptSecurityManager;

public class StandardSecurityManager implements ScriptSecurityManager {

    private boolean securityMode;

    @Override
    public boolean getSecurityMode() {
        return securityMode;
    }

    @Override
    public void setSecurityMode(boolean securityMode) {
        this.securityMode = securityMode;
    }
}
