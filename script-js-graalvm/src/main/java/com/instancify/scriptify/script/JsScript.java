package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import org.graalvm.polyglot.*;

public class JsScript implements Script<Value> {

    private final Context context = Context.create();
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
    public Value eval(String script) throws ScriptException {
        Value bindings = context.getBindings("js");

        if (functionManager != null) {
            for (ScriptFunction function : functionManager.getFunctions().values()) {
                bindings.putMember(function.getName(), new JsFunction(this, function));
            }
        }

        if (constantManager != null) {
            for (ScriptConstant constant : constantManager.getConstants().values()) {
                bindings.putMember(constant.getName(), constant.getValue());
            }
        }

        try {
            return context.eval("js", script);
        } catch (Exception e) {
            throw new ScriptException(e);
        }
    }
}
