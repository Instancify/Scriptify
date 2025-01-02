package com.instancify.scriptify.script;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import org.mozilla.javascript.*;

public class JsScript implements Script {

    private final String scriptString;
    private final Context context = Context.enter();
    private final ScriptableObject scope = context.initStandardObjects();
    private ScriptFunctionManager functionManager;
    private ScriptConstantManager constantManager;

    public JsScript(String scriptString) {
        this.scriptString = scriptString;
    }

    @Override
    public void setFunctionManager(ScriptFunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public void setConstantManager(ScriptConstantManager constantManager) {
        this.constantManager = constantManager;
    }

    @Override
    public void eval() {
        for(ScriptFunction function : functionManager.getFunctions().values()) {
            scope.put(function.getName(), scope, new JsFunction(function));
        }
        for(ScriptConstant constant : constantManager.getConstants().values()) {
            ScriptableObject.putConstProperty(scope, constant.getName(), constant.getValue());
        }
        context.evaluateString(scope, scriptString, null, 1, null);
    }
}
