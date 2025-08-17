package com.instancify.scriptify.common.script.function.impl.file;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import com.instancify.scriptify.api.script.function.annotation.Executor;
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

    @ExecuteAt
    public boolean execute(
            @Executor Script<?> script,
            @Argument(name = "original") String originalFilePath,
            @Argument(name = "target") String targetFilePath
    ) {
        File fileToMove = script.getSecurityManager().getFileSystem().getFile(originalFilePath);
        return fileToMove.renameTo(script.getSecurityManager().getFileSystem().getFile(targetFilePath));
    }
}
