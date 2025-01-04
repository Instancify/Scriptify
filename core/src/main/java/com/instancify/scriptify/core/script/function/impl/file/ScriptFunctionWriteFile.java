package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a function to write the contents of a file
 */
public class ScriptFunctionWriteFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "writeFile";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length == 2) {
            if (args[0].getValue() instanceof String filePath && args[1].getValue() instanceof String fileContent) {
                try {
                    return Files.writeString(Path.of(filePath), fileContent);
                } catch (IOException e) {
                    throw new ScriptFunctionException(e);
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
            }
        } else {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }
    }
}
