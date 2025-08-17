package com.instancify.scriptify.common.script.function.impl.util;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a function to create a list from the passed arguments
 */
public class ScriptFunctionListOf implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "listOf";
    }

    @ExecuteAt
    public List<?> execute(
            @Argument(name = "args") Object... args
    ) {
        return Arrays.asList(args);
    }
}
