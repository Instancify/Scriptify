package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.File;

/**
 * Represents a function to delete a file in the normal or recursive way
 */
public class ScriptFunctionDeleteFile implements ScriptFunction {

    @Override
    public String getName() {
        return "deleteFile";
    }

    // TODO refactor it
    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length == 1) {
            if (args[0] instanceof String filePath) {
                try {
                    return new File(filePath).delete();
                } catch (Exception e) {
                    return null;
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
            }
        } else if (args.length == 2) {
            if (args[0] instanceof String filePath) {
                if (args[1] instanceof Boolean recursive) {
                    try {
                        File file = new File(filePath);
                        if (recursive) {
                            deleteDirectoryRecursively(file);
                            return null;
                        } else {
                            return file.delete();
                        }
                    } catch (Exception e) {
                        return null;
                    }
                } else {
                    throw new ScriptFunctionArgTypeException(Boolean.class, args[1].getClass());
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
            }
        } else {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }
    }

    private void deleteDirectoryRecursively(File file) throws ScriptFunctionException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        if (!file.delete()) {
            throw new ScriptFunctionException("Failed to delete " + file);
        }
    }
}
