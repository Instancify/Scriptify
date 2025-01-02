package com.instancify.scriptify.api.script;

import com.instancify.scriptify.api.script.function.ScriptFunctionManager;

public interface Script {

    void setFunctionManager(ScriptFunctionManager functionManager);

    void eval();
}
