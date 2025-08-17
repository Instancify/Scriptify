package com.instancify.scriptify.common.script.function.impl.file;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import com.instancify.scriptify.api.script.function.annotation.Executor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Represents a function to write the contents of a file
 */
public class ScriptFunctionWriteFile implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "writeFile";
    }

    @ExecuteAt
    public Object execute(
            @Executor Script<?> script,
            @Argument(name = "filePath") String filePath,
            @Argument(name = "fileContent") String fileContent
    ) {
        try {
            return Files.writeString(script.getSecurityManager().getFileSystem().getPath(filePath), fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
