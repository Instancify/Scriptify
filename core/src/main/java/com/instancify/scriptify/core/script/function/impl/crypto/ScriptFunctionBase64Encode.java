package com.instancify.scriptify.core.script.function.impl.crypto;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.jetbrains.annotations.NotNull;

import java.util.Base64;

/**
 * Represents a function to encode string to base64
 */
public class ScriptFunctionBase64Encode implements ScriptFunction {
    @Override
    public @NotNull String getName() {
        return "base64encode";
    }

    @Override
    public Object invoke(Script script, Object[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0] instanceof String str)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }

        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
