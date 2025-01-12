package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;
import com.instancify.scriptify.core.script.function.impl.http.ScriptFunctionCreateHttpRequest;

public class Test {
    public static void main(String[] args) {
        JsScript script = new JsScript();
        script.setFunctionManager(new StandardFunctionManager());
        script.setConstantManager(new StandardConstantManager());
        script.getFunctionManager().register(new ScriptFunctionCreateHttpRequest());
        try {
        script.eval("""
                const goida = createHttpRequest("https://example.com", "GET");
                print(goida.send());
                """);
        } catch(ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}
