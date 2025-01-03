package com.instancify.scriptify.core.script.function.impl.os;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

/**
 * Represents a function to get environment variable value
 */
public class ScriptFunctionGetEnv implements ScriptFunction {

    @Override
    public String getName() {
        return "env";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0] instanceof String name)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }

        return System.getenv(name);
    }
}
