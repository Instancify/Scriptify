package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.api.script.security.ScriptSecurityManager;
import com.instancify.scriptify.core.script.security.StandardSecurityManager;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class JsScript implements Script<Object> {

    private final Context context = Context.enter();
    private final ScriptSecurityManager securityManager = new StandardSecurityManager();
    private ScriptFunctionManager functionManager;
    private ScriptConstantManager constantManager;

    public JsScript() {
        context.setWrapFactory(new JsWrapFactory());
    }

    @Override
    public ScriptSecurityManager getSecurityManager() {
        return securityManager;
    }

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
    public Object eval(String script) throws ScriptException {
        ScriptableObject scope = context.initStandardObjects();

        // If security mode is enabled, search all exclusions
        // and add the classes that were excluded to JsSecurityClassAccessor
        if (securityManager.getSecurityMode()) {
            context.setClassShutter(new JsSecurityClassAccessor(securityManager.getExcludes()));
        }

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

        try {
            return context.evaluateString(scope, script, null, 1, null);
        } catch (Exception e) {
            throw new ScriptException(e);
        } finally {
            context.close();
        }
    }
}
