package com.instancify.scriptify.api.exception;

public class ScriptFunctionArgumentCountMismatchException extends ScriptFunctionException {

    public ScriptFunctionArgumentCountMismatchException(String functionName,
                                                        int expectedMin,
                                                        int expectedMax,
                                                        int provided) {
        super("Function '" + functionName + "' expects between " +
                expectedMin + " and " + expectedMax + " arguments, but got " + provided);
    }
}
