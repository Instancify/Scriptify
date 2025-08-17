package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Represents a function to create an array from the passed arguments
 */
public class ScriptFunctionArrayOf implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "arrayOf";
    }

    @ExecuteAt
    public Object[] execute(
            @Argument(name = "args") Object... args
    ) {
        return Arrays.stream(args).toArray();
    }
}
