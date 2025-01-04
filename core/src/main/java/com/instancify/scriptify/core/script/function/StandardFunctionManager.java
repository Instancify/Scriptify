package com.instancify.scriptify.core.script.function;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.core.script.function.impl.ScriptFunctionPrint;
import com.instancify.scriptify.core.script.function.impl.ScriptFunctionShuffleArray;
import com.instancify.scriptify.core.script.function.impl.crypto.ScriptFunctionBase64Decode;
import com.instancify.scriptify.core.script.function.impl.crypto.ScriptFunctionBase64Encode;
import com.instancify.scriptify.core.script.function.impl.crypto.ScriptFunctionMD5;
import com.instancify.scriptify.core.script.function.impl.crypto.ScriptFunctionSHA256;
import com.instancify.scriptify.core.script.function.impl.file.*;
import com.instancify.scriptify.core.script.function.impl.os.ScriptFunctionEnv;
import com.instancify.scriptify.core.script.function.impl.os.ScriptFunctionExecCommand;
import com.instancify.scriptify.core.script.function.impl.random.*;
import com.instancify.scriptify.core.script.function.impl.zip.ScriptFunctionSmartUnzipFile;
import com.instancify.scriptify.core.script.function.impl.zip.ScriptFunctionSmartZipFile;
import com.instancify.scriptify.core.script.function.impl.zip.ScriptFunctionUnzipFile;
import com.instancify.scriptify.core.script.function.impl.zip.ScriptFunctionZipFile;

import java.util.HashMap;
import java.util.Map;

public class StandardFunctionManager implements ScriptFunctionManager {

    private final Map<String, ScriptFunction> functions = new HashMap<>();

    public StandardFunctionManager() {
        this.register(new ScriptFunctionPrint());
        this.register(new ScriptFunctionExistsFile());
        this.register(new ScriptFunctionDeleteFile());
        this.register(new ScriptFunctionMoveFile());
        this.register(new ScriptFunctionListFiles());
        this.register(new ScriptFunctionReadFile());
        this.register(new ScriptFunctionWriteFile());
        this.register(new ScriptFunctionZipFile());
        this.register(new ScriptFunctionUnzipFile());
        this.register(new ScriptFunctionSmartUnzipFile());
        this.register(new ScriptFunctionSmartZipFile());
        this.register(new ScriptFunctionNormalizePath());
        this.register(new ScriptFunctionBase64Encode());
        this.register(new ScriptFunctionBase64Decode());
        this.register(new ScriptFunctionDownloadFromUrl());
        this.register(new ScriptFunctionJoinPath());
        this.register(new ScriptFunctionRandomUUID());
        this.register(new ScriptFunctionRandomInteger());
        this.register(new ScriptFunctionRandomLong());
        this.register(new ScriptFunctionRandomFloat());
        this.register(new ScriptFunctionRandomDouble());
        this.register(new ScriptFunctionMD5());
        this.register(new ScriptFunctionSHA256());
        this.register(new ScriptFunctionExecCommand());
        this.register(new ScriptFunctionEnv());
        this.register(new ScriptFunctionShuffleArray());
    }

    @Override
    public Map<String, ScriptFunction> getFunctions() {
        return functions;
    }

    @Override
    public void register(ScriptFunction function) {
        if (!functions.containsKey(function.getName())) {
            functions.put(function.getName(), function);
        } else {
            throw new IllegalStateException("The function with this name already exists");
        }
    }

    @Override
    public void remove(String name) {
        if (functions.containsKey(name)) {
            functions.remove(name);
        } else {
            throw new IllegalArgumentException("The function with this name does not exist");
        }
    }
}