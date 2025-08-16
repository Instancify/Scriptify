package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a function to get all files in a folder
 */
public class ScriptFunctionListFiles implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "listFiles";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length == 1) {
            if (args[0].getValue() instanceof String filePath) {
                File folder = script.getSecurityManager().getFileSystem().getFile(filePath);
                if (folder.isDirectory()) {
                    return Arrays.stream(Objects.requireNonNull(folder.listFiles())).map(File::getAbsolutePath).toList();
                } else {
                    throw new ScriptFunctionException("File is not a folder");
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
            }
        } else {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
    }
}