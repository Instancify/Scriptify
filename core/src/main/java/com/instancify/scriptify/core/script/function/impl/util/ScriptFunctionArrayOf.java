package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
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

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        return Arrays.stream(args).map(ScriptFunctionArgument::getValue).toArray();
    }
}
