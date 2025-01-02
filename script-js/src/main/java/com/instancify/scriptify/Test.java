package com.instancify.scriptify;

import com.instancify.scriptify.script.JsScript;
import com.instancify.scriptify.script.StandartFunctionManager;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript("print(\"test\"); print(\"test2\");");
        StandartFunctionManager functionManager = new StandartFunctionManager();

        script.setFunctionManager(functionManager);
        script.eval();
    }
}
