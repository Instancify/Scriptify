package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a function to read the contents of a file
 */
public class ScriptFunctionReadFile implements ScriptFunction {

    @Override
    public String getName() {
        return "readFile";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length == 1) {
            if (args[0] instanceof String filePath) {
                try {
                    return Files.readString(Path.of(filePath));
                } catch (IOException e) {
                    throw new ScriptFunctionException(e);
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
            }
        } else {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
    }
}
