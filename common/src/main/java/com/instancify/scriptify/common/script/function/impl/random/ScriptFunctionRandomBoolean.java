package com.instancify.scriptify.common.script.function.impl.random;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Represents a function to generate random long number
 */
public class ScriptFunctionRandomBoolean implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "randomBoolean";
    }

    @ExecuteAt
    public boolean execute() {
        return new Random().nextBoolean();
    }
}
