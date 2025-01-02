package com.instancify.scriptify.api.exception;

public class ScriptFunctionArgTypeException extends ScriptFunctionException {

    public ScriptFunctionArgTypeException(Class<?> required, Class<?> provided) {
        super("Required argument type: " + required + ", passed: " + provided);
    }
}
