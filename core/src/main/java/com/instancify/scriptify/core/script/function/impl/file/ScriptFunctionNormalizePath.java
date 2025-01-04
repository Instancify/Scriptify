package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.jetbrains.annotations.NotNull;

public class ScriptFunctionNormalizePath implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "normalizePath";
    }

    @Override
    public Object invoke(Script<?> script, Object[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0] instanceof String path)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }

        return path.replace('\\', '/');
    }
}