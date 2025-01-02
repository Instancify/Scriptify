package com.instancify.scriptify.core.script.function;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.core.script.function.impl.*;

import java.util.HashMap;
import java.util.Map;

public class StandardFunctionManager implements ScriptFunctionManager {

    private final Map<String, ScriptFunction> functions = new HashMap<>();

    public StandardFunctionManager() {
        this.register(new ScriptFunctionPrint());
        this.register(new ScriptFunctionExistsFile());
        this.register(new ScriptFunctionDeleteFile());
        this.register(new ScriptFunctionReadFile());
        this.register(new ScriptFunctionWriteFile());
        this.register(new ScriptFunctionZipFile());
        this.register(new ScriptFunctionUnzipFile());
        this.register(new ScriptFunctionSmartUnzipFile());
    }

    @Override
    public Map<String, ScriptFunction> getFunctions() {
        return functions;
    }

    @Override
    public void register(ScriptFunction function) {
        functions.put(function.getName(), function);
    }
}