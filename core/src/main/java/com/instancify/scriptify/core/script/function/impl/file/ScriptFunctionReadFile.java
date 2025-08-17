package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import com.instancify.scriptify.api.script.function.annotation.Executor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Represents a function to read the contents of a file
 */
public class ScriptFunctionReadFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "readFile";
    }

    @ExecuteAt
    public Object execute(
            @Executor Script<?> script,
            @Argument(name = "filePath") String filePath
    ) {
        try {
            return Files.readString(script.getSecurityManager().getFileSystem().getPath(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
