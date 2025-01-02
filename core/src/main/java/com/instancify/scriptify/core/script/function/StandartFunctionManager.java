package com.instancify.scriptify.core.script.function;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.core.script.function.impl.ScriptFunctionDeleteFile;
import com.instancify.scriptify.core.script.function.impl.ScriptFunctionPrint;
import com.instancify.scriptify.core.script.function.impl.ScriptFunctionReadFile;

import java.util.HashMap;
import java.util.Map;

public class StandartFunctionManager implements ScriptFunctionManager {

    private final Map<String, ScriptFunction> functions = new HashMap<>();

    public StandartFunctionManager() {
        this.register(new ScriptFunctionPrint());
        this.register(new ScriptFunctionDeleteFile());
        this.register(new ScriptFunctionReadFile());
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