package com.instancify.scriptify.api.exception;

public class ScriptFunctionArgsCountException extends ScriptFunctionException {

    public ScriptFunctionArgsCountException(int required, int provided) {
        super("Required number of arguments: " + required + ", passed: " + provided);
    }
}
