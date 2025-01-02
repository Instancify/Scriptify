package com.instancify.scriptify.api.script.function;

import java.util.Map;

/**
 * Manages script functions, providing registration and retrieval capabilities.
 */
public interface ScriptFunctionManager {

    /**
     * Retrieves all registered functions.
     *
     * @return A map where keys are function names and values are ScriptFunction instances
     */
    Map<String, ScriptFunction> getFunctions();

    /**
     * Gets a specific function by its name.
     *
     * @param name The name of the function to retrieve
     * @return The ScriptFunction associated with the name, or null if not found
     */
    default ScriptFunction getFunction(String name) {
        return this.getFunctions().get(name);
    }

    /**
     * Registers a new function in the manager.
     *
     * @param scriptFunction The function to be registered
     */
    void register(ScriptFunction scriptFunction);
}
