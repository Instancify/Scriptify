package com.instancify.scriptify.api.exception;

public class ScriptFunctionException extends Exception {

    public ScriptFunctionException(String message) {
        super(message);
    }

    public ScriptFunctionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScriptFunctionException(Throwable cause) {
        super(cause);
    }
}
