package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
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

    @ExecuteAt
    public List<?> execute(
            @Argument(name = "array") List<?> array
    ) {
        List<?> list = new ArrayList<>(array);
        Collections.shuffle(list);
        return list;
    }
}
