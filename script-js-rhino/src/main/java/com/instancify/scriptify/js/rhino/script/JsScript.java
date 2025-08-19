package com.instancify.scriptify.js.rhino.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.api.script.function.definition.ScriptFunctionDefinition;
import com.instancify.scriptify.api.script.security.ScriptSecurityManager;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;
import com.instancify.scriptify.core.script.security.StandardSecurityManager;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import java.util.ArrayList;
import java.util.List;

public class JsScript implements Script<Object> {

    private final Context context = Context.enter();
    private final ScriptSecurityManager securityManager = new StandardSecurityManager();
    private ScriptFunctionManager functionManager = new StandardFunctionManager();
    private ScriptConstantManager constantManager = new StandardConstantManager();
    private final List<String> extraScript = new ArrayList<>();

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
    public void addExtraScript(String script) {
        this.extraScript.add(script);
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
            for (ScriptFunctionDefinition definition : functionManager.getFunctions().values()) {
                scope.put(definition.getFunction().getName(), scope, new JsFunction(this, definition));
            }
        }

        if (constantManager != null) {
            for (ScriptConstant constant : constantManager.getConstants().values()) {
                ScriptableObject.putConstProperty(scope, constant.getName(), constant.getValue());
            }
        }

        // Building full script including extra script code
        StringBuilder fullScript = new StringBuilder();
        for (String extra : extraScript) {
            fullScript.append(extra).append("\n");
        }
        fullScript.append(script);

        try {
            return context.evaluateString(scope, fullScript.toString(), null, 1, null);
        } catch (Exception e) {
            throw new ScriptException(e);
        } finally {
            context.close();
        }
    }
}
