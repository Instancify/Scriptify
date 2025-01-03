package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.File;

/**
 * Represents a function to move file
 */
public class ScriptFunctionMoveFile implements ScriptFunction {

    @Override
    public String getName() {
        return "moveFile";
    }

    @Override
    public Object invoke(Script script, Object[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0] instanceof String originalFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }
        if (!(args[1] instanceof String targetFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
        }

        File fileToMove = new File(originalFilePath);
        return fileToMove.renameTo(new File(targetFilePath));
    }
}
