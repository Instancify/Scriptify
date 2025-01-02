package com.instancify.scriptify.core;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

public class ScriptFunctionPrint implements ScriptFunction {
    @Override
    public String getName() {
        return "print";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        System.out.println(args[0]);
        return null;
    }
}
