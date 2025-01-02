package com.instancify.scriptify.api.exception;

/**
 * Exception for script function argument type mismatches.
 */
public class ScriptFunctionArgTypeException extends ScriptFunctionException {

    /**
     * Creates an exception when argument types don't match.
     *
     * @param required The expected type
     * @param provided The type that was given
     */
    public ScriptFunctionArgTypeException(Class<?> required, Class<?> provided) {
        super("Required argument type: " + required + ", passed: " + provided);
    }
}
