package com.instancify.scriptify.core.script.function.impl.random;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Represents a function to generate random UUID
 */
public class ScriptFunctionRandomUUID implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "randomUUID";
    }

    @Override
    public Object invoke(Script script, Object[] args) throws ScriptFunctionException {
        return UUID.randomUUID().toString();
    }
}
