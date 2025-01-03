package com.instancify.scriptify.core.script.constant;

import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.core.script.constant.impl.ScriptConstantBaseDir;
import com.instancify.scriptify.core.script.constant.impl.ScriptConstantOsName;

import java.util.HashMap;
import java.util.Map;

public class StandardConstantManager implements ScriptConstantManager {

    private final Map<String, ScriptConstant> constants = new HashMap<>();

    public StandardConstantManager() {
        register(new ScriptConstantOsName());
        register(new ScriptConstantBaseDir());
    }

    @Override
    public Map<String, ScriptConstant> getConstants() {
        return constants;
    }

    @Override
    public void register(ScriptConstant constant) {
        constants.put(constant.getName(), constant);
    }
}