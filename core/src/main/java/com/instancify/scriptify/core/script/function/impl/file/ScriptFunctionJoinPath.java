package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
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
    public Object invoke(Script<?> script, Object[] args) throws ScriptFunctionException {
        String path = "";
        for (Object arg : args) {
            if (arg instanceof String segment) {
                if (path.isEmpty()) {
                    path += segment;
                } else {
                    path += '/' + segment;
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
            }
        }
        return path;
    }
}
