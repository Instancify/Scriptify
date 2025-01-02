package com.instancify.scriptify;

import com.instancify.scriptify.script.JsScript;
import com.instancify.scriptify.core.script.function.StandartFunctionManager;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript("deleteFile('.idea', true);");
        StandartFunctionManager functionManager = new StandartFunctionManager();

        script.setFunctionManager(functionManager);
        script.eval();
    }
}
