package com.instancify.scriptify.core.script.function.impl.util;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * Represents a function to match regex pattern
 */
public class ScriptFunctionRegexMatch implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "regex_match";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        Pattern pattern;
        if (args[0].getValue() instanceof String regex) {
            pattern = Pattern.compile(regex);
        } else if (args[0].getValue() instanceof Pattern) {
            pattern = (Pattern) args[0].getValue();
        } else {
            throw new ScriptFunctionArgTypeException(Set.of(String.class, Pattern.class), args[0].getType());
        }

        if (!(args[1].getValue() instanceof String value)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
        }

        return pattern.matcher(value).matches();
    }
}
