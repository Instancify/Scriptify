package com.instancify.scriptify.api.script.function;

import java.util.Map;

public interface ScriptFunctionManager {

    Map<String, ScriptFunction> getFunctions();

    default ScriptFunction getFunction(String name) {
        return this.getFunctions().get(name);
    }

    void register(ScriptFunction scriptFunction);
}
