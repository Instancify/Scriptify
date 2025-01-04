package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a function for outputting messages to the console
 */
public class ScriptFunctionPrint implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "print";
    }

    @Override
    public Object invoke(Script<?> script, Object[] args) {
        System.out.println(Arrays.stream(args).map(String::valueOf).collect(Collectors.joining(" ")));
        return null;
    }
}
