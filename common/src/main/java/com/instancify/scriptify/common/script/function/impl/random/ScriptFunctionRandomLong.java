package com.instancify.scriptify.common.script.function.impl.random;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Represents a function to generate random long number
 */
public class ScriptFunctionRandomLong implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "randomLong";
    }

    @ExecuteAt
    public long execute(
            @Argument(name = "max") Long max
    ) {
        return new Random().nextLong(max);
    }

    @ExecuteAt
    public long execute(
            @Argument(name = "min") Long min,
            @Argument(name = "max") Long max
    ) {
        return new Random().nextLong(min, max);
    }
}
