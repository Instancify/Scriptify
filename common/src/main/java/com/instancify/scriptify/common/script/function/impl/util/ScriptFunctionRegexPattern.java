package com.instancify.scriptify.common.script.function.impl.util;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

/**
 * Represents a function to compile regex pattern.
 */
public class ScriptFunctionRegexPattern implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "regex_pattern";
    }

    @ExecuteAt
    public Pattern execute(
            @Argument(name = "pattern") String pattern
    ) {
        return Pattern.compile(pattern);
    }
}
