package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Represents a function to move file
 */
public class ScriptFunctionMoveFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "moveFile";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0].getValue() instanceof String originalFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
        }
        if (!(args[1].getValue() instanceof String targetFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
        }

        File fileToMove = script.getSecurityManager().getFileSystem().getFile(originalFilePath);
        return fileToMove.renameTo(script.getSecurityManager().getFileSystem().getFile(targetFilePath));
    }
}
