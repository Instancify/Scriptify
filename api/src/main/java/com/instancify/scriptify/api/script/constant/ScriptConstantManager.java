package com.instancify.scriptify.api.script.constant;

import java.util.Map;

/**
 * Manages constants for use in scripts, providing methods to retrieve and register them.
 */
public interface ScriptConstantManager {

    /**
     * Retrieves all registered constants.
     *
     * @return A map where keys are constant names and values are ScriptConstant instances
     */
    Map<String, ScriptConstant> getConstants();

    /**
     * Gets a specific constant by its name.
     *
     * @param name The name of the constant to retrieve
     * @return The ScriptConstant associated with the name, or null if not found
     */
    default ScriptConstant getConstant(String name) {
        return this.getConstants().get(name);
    }

    /**
     * Registers a new constant in the manager.
     *
     * @param constant The constant to be registered
     */
    void register(ScriptConstant constant);
}
