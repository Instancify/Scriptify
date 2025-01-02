package com.instancify.scriptify.api.script.function;

import java.util.Map;

public interface ScriptFunctionManager {

    Map<String, ScriptFunction> getFunctions();

    void register(ScriptFunction scriptFunction);
}
