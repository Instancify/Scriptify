package com.instancify.scriptify.common.script.constant;

import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.constant.impl.ScriptConstantBaseDir;
import com.instancify.scriptify.core.script.constant.impl.ScriptConstantOsName;

public class CommonConstantManager extends StandardConstantManager {

    public CommonConstantManager() {
        this.register(new ScriptConstantOsName());
        this.register(new ScriptConstantBaseDir());
    }
}
