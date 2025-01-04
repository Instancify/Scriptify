package com.instancify.scriptify.api.script.security;

import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.security.exclude.SecurityExclude;

import java.util.Set;

public interface ScriptSecurityManager {

    /**
     * Gets a current security mode.
     *
     * @return The boolean associated with security mode state
     */
    boolean getSecurityMode();

    SecurityPathAccessor getSecurityPathAccessor();

    /**
     * Sets the current security mode.
     *
     * @param securityMode The boolean associated with security mode state
     * @see ScriptConstantManager
     */
    void setSecurityMode(boolean securityMode);

    /**
     * Retrieves all existing exclusions for this script.
     *
     * @return Set with exclusions
     */
    Set<SecurityExclude> getExcludes();

    /**
     * Adds an exclusion for a path or package.
     *
     * @param exclude The exclusion to be added
     */
    void addExclude(SecurityExclude exclude);

    /**
     * Removes an exclusion for a path or package.
     *
     * @param exclude The exclusion to remove
     */
    void removeExclude(SecurityExclude exclude);
}
