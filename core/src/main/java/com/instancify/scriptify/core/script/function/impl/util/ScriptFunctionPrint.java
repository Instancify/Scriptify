package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
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
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) {
        System.out.println(Arrays.stream(args).map(arg -> arg.getValue().toString()).collect(Collectors.joining(" ")));
        return null;
    }

    @ExecuteAt
    public Object execute(
            @Argument(name = "args") Object... args
    ) {
        System.out.println(Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" ")));
        return null;
    }
}
