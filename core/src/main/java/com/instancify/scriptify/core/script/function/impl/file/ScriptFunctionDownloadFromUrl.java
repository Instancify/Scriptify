package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

/**
 * Represents a function to download file from url
 */
public class ScriptFunctionDownloadFromUrl implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "downloadFromUrl";
    }

    @Override
    public Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0].getValue() instanceof String url)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
        }
        if (!(args[1].getValue() instanceof String filePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
        }

        try (InputStream in = new URL(url).openStream()) {
            File targetPath = new File(filePath);
            Files.copy(in, targetPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
