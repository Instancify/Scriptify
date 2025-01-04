package com.instancify.scriptify;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;
import com.instancify.scriptify.script.JsScript;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript();
        script.setConstantManager(new StandardConstantManager());
        script.setFunctionManager(new StandardFunctionManager());
        script.getSecurityManager().setSecurityMode(true);

        try {
            script.eval("""
                    writeFile(normalizePath("E:\\\\penis.txt"), "asdsas");
                    """);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
