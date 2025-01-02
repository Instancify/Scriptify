package com.instancify.scriptify.api.exception;

/**
 * Exception for when the count of arguments in a script function call is incorrect.
 */
public class ScriptFunctionArgsCountException extends ScriptFunctionException {

    /**
     * Creates an exception when the number of arguments doesn't match.
     *
     * @param required The expected number of arguments
     * @param provided The number of arguments actually provided
     */
    public ScriptFunctionArgsCountException(int required, int provided) {
        super("Required number of arguments: " + required + ", passed: " + provided);
    }
}
