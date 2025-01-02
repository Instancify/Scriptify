package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.util.UUID;

public class ScriptFunctionRandomUUID implements ScriptFunction {

    @Override
    public String getName() {
        return "randomUUID";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        return UUID.randomUUID().toString();
    }
}
