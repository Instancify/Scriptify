package com.instancify.scriptify;

import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.script.JsScript;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript("""
                downloadFromUrl("https://repo.instancify.app/snapshots/com/instancify/scriptify/script-js/1.0.2-SNAPSHOT/script-js-1.0.2-20250102.210939-4.jar", "script-js.jar")
                """);

        StandardFunctionManager functionManager = new StandardFunctionManager();
        StandardConstantManager constantManager = new StandardConstantManager();
        constantManager.register(ScriptConstant.of("helloWorld", "Hello world from Script via constant"));

        script.setFunctionManager(functionManager);
        script.setConstantManager(constantManager);
        script.eval();
    }
}
