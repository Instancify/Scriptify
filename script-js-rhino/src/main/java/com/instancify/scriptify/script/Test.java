package com.instancify.scriptify.script;

import com.instancify.scriptify.core.script.function.StandardFunctionManager;

public class Test {

    public static void main(String[] args) {
        JsScript script = new JsScript();
//        script.getFunctionManager().register(null);

        script.setFunctionManager(new StandardFunctionManager());
        script.getFunctionManager().register(null);
    }
}
