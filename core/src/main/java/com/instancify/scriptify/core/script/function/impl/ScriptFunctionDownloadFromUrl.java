package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

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
    public String getName() {
        return "downloadFromUrl";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length != 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0] instanceof String url)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }
        if (!(args[1] instanceof String filePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
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
