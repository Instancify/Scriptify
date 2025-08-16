package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a function to check the existence of a file
 */
public class ScriptFunctionExistsFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "existsFile";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length == 1) {
            if (args[0].getValue() instanceof String filePath) {
                return Files.exists(script.getSecurityManager().getFileSystem().getPath(filePath));
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
            }
        } else {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
    }
}
