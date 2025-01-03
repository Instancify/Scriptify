package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a function to check the existence of a file
 */
public class ScriptFunctionExistsFile implements ScriptFunction {

    @Override
    public String getName() {
        return "existsFile";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length == 1) {
            if (args[0] instanceof String filePath) {
                return Files.exists(Path.of(filePath));
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
            }
        } else {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
    }
}
