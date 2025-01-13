package com.instancify.scriptify.core.script.function.impl.http;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import com.instancify.scriptify.core.script.function.data.http.HttpRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a function create http request
 */
public class ScriptFunctionCreateHttpRequest implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "createHttpRequest";
    }

    @Override
    public @Nullable Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0].getValue() instanceof String url)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
        }

        if (!(args[1].getValue() instanceof String method)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
        }

        return new HttpRequest(url, method);
    }
}
