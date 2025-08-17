package com.instancify.scriptify.api.exception;

public class ScriptFunctionArgumentTypeMismatchException extends ScriptFunctionException {

    public ScriptFunctionArgumentTypeMismatchException(String functionName,
                                                       int index,
                                                       Class<?> expected,
                                                       Class<?> actual) {
        super("Function '" + functionName + "' argument #" + index +
                " expected type " + expected.getName() +
                " but got " + (actual == null ? "null" : actual.getName()));
    }
}

