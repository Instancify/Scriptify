package com.instancify.scriptify.common.script.function.impl.random;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
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

    @ExecuteAt
    public String execute() {
        return UUID.randomUUID().toString();
    }
}
