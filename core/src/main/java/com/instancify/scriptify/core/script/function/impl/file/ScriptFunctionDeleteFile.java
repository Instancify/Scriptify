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
 * Represents a function to delete a file in the normal or recursive way
 */
public class ScriptFunctionDeleteFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "deleteFile";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length > 2 || args.length < 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
        if (!(args[0].getValue() instanceof String filePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
        }

        if (args.length == 1) {
            return new File(filePath).delete();
        }

        if (!(args[1].getValue() instanceof Boolean recursive)) {
            throw new ScriptFunctionArgTypeException(Boolean.class, args[1].getType());
        }

        File file = new File(filePath);
        if (recursive) {
            return deleteDirectoryRecursively(file);
        } else {
            return file.delete();
        }
    }

    private boolean deleteDirectoryRecursively(File file) {
        boolean success = true;

        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    if (!deleteDirectoryRecursively(entry)) {
                        success = false;
                    }
                }
            }
        }

        if (!file.delete()) {
            success = false;
        }

        return success;
    }
}
