package com.instancify.scriptify.api.script.security;

import com.instancify.scriptify.api.script.constant.ScriptConstantManager;

public interface ScriptSecurityManager {

    /**
     * Gets a current security mode
     *
     * @return The boolean associated with security mode state
     */
    boolean getSecurityMode();

    /**
     * Sets the current security mode
     *
     * @param securityMode The boolean associated with security mode state
     * @see ScriptConstantManager
     */
    void setSecurityMode(boolean securityMode);
}
