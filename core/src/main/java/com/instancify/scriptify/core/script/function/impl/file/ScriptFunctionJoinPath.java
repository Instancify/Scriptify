package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a function to join path
 */
public class ScriptFunctionJoinPath implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "joinPath";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        String path = "";
        for (ScriptFunctionArgument arg : args) {
            if (arg.getValue() instanceof String segment) {
                if (path.isEmpty()) {
                    path += segment;
                } else {
                    path += '/' + segment;
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
            }
        }
        return path;
    }
}
