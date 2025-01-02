package com.instancify.scriptify;

import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.script.JsScript;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript("""
                print(readFile(joinPath("script-js", "src", "main", "java", "com", "instancify", "scriptify", "Test.java")));
                """);

        StandardFunctionManager functionManager = new StandardFunctionManager();
        StandardConstantManager constantManager = new StandardConstantManager();
        constantManager.register(ScriptConstant.of("helloWorld", "Hello world from Script via constant"));

        script.setFunctionManager(functionManager);
        script.setConstantManager(constantManager);
        script.eval();
    }
}
