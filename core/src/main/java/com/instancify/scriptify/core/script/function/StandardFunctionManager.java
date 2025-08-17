package com.instancify.scriptify.core.script.function;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.api.script.function.definition.ScriptFunctionDefinition;
import com.instancify.scriptify.core.script.function.definition.ScriptFunctionDefinitionImpl;

import java.util.HashMap;
import java.util.Map;

public class StandardFunctionManager implements ScriptFunctionManager {

    private final Map<String, ScriptFunctionDefinition> functions = new HashMap<>();

    @Override
    public Map<String, ScriptFunctionDefinition> getFunctions() {
        return functions;
    }

    @Override
    public void register(ScriptFunction function) {
        if (!functions.containsKey(function.getName())) {
            functions.put(function.getName(), new ScriptFunctionDefinitionImpl(function));
        } else {
            throw new IllegalStateException("The function with name '" + function.getName() + "' already exists");
        }
    }

    @Override
    public void remove(String name) {
        if (functions.containsKey(name)) {
            functions.remove(name);
        } else {
            throw new IllegalArgumentException("The function with name '" + name + "' does not exist");
        }
    }
}