package com.instancify.scriptify.api.script.function;

import com.instancify.scriptify.api.exception.ScriptFunctionException;

/**
 * Represents a function that can be used within scripts.
 */
public interface ScriptFunction {

    /**
     * Gets the name of the function.
     *
     * @return The function's name
     */
    String getName();

    /**
     * Invokes the function with the provided arguments.
     *
     * @param args The arguments to pass to the function
     * @return The result of the function execution
     * @throws ScriptFunctionException If there's an error during invocation
     */
    Object invoke(Object[] args) throws ScriptFunctionException;
}
