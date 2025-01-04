package com.instancify.scriptify.script;

import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class JsScript implements Script {

    private final Context context = Context.enter();
    private final ScriptableObject scope = context.initStandardObjects();
    private ScriptFunctionManager functionManager;
    private ScriptConstantManager constantManager;

    @Override
    public ScriptFunctionManager getFunctionManager() {
        return functionManager;
    }

    @Override
    public void setFunctionManager(ScriptFunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public ScriptConstantManager getConstantManager() {
        return constantManager;
    }

    @Override
    public void setConstantManager(ScriptConstantManager constantManager) {
        this.constantManager = constantManager;
    }

    @Override
    public void eval(String script) {
        if (functionManager != null) {
            for (ScriptFunction function : functionManager.getFunctions().values()) {
                scope.put(function.getName(), scope, new JsFunction(this, function));
            }
        }

        if (constantManager != null) {
            for (ScriptConstant constant : constantManager.getConstants().values()) {
                ScriptableObject.putConstProperty(scope, constant.getName(), constant.getValue());
            }
        }

        context.evaluateString(scope, script, null, 1, null);
    }
}
