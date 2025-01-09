package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.constant.ScriptConstant;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.api.script.security.ScriptSecurityManager;
import com.instancify.scriptify.api.script.security.exclude.ClassSecurityExclude;
import com.instancify.scriptify.api.script.security.exclude.SecurityExclude;
import com.instancify.scriptify.core.script.security.StandardSecurityManager;
import org.graalvm.polyglot.*;

public class JsScript implements Script<Value> {

    private final ScriptSecurityManager securityManager = new StandardSecurityManager();
    private ScriptFunctionManager functionManager;
    private ScriptConstantManager constantManager;

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
    public Value eval(String script) throws ScriptException {
        Context.Builder builder = Context.newBuilder("js")
                .allowHostAccess(HostAccess.ALL);

        // If security mode is enabled, search all exclusions
        // and add the classes that were excluded to JsSecurityClassAccessor
        if (securityManager.getSecurityMode()) {
            builder.allowHostClassLookup(new JsSecurityClassAccessor(securityManager.getExcludes()));
        } else {
            builder.allowHostClassLookup(className -> true);
        }

        Context context = builder.build();

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
        } finally {
            context.close();
        }
    }
}
