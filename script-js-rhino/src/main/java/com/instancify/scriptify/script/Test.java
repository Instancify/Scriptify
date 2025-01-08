package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.script.security.exclude.ClassSecurityExclude;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;

import java.io.File;

public class Test {
    public static void main(String[] args) {

        JsScript script = new JsScript();
        script.setFunctionManager(new StandardFunctionManager());
        script.setConstantManager(new StandardConstantManager());
        script.getSecurityManager().setSecurityMode(true);
        script.getSecurityManager().addExclude(new ClassSecurityExclude(File.class));

        try {
            script.eval("""
                    const test = new java.io.File("test.txt");
                    
                    """);
        } catch(ScriptException e) {
            throw new RuntimeException(e);
        }

    }
}
