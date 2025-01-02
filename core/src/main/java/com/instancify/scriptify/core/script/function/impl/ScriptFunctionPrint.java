package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a function for outputting messages to the console
 */
public class ScriptFunctionPrint implements ScriptFunction {

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public Object invoke(Object[] args) {
        System.out.println(Arrays.stream(args).map(String::valueOf).collect(Collectors.joining(" ")));
        return null;
    }
}
