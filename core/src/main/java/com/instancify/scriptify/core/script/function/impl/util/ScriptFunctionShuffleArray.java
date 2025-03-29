package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a function to shuffle an array
 */
public class ScriptFunctionShuffleArray implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "shuffleArray";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0].getValue() instanceof List<?> array)) {
            throw new ScriptFunctionArgTypeException(List.class, args[0].getType());
        }

        List<?> list = new ArrayList<Object>(array);
        Collections.shuffle(list);

        return list;
    }
}
