package com.instancify.scriptify.api.script.function;

import com.instancify.scriptify.api.exception.ScriptFunctionException;

public interface ScriptFunction {

    String getName();

    Object invoke(Object[] args) throws ScriptFunctionException;
}
