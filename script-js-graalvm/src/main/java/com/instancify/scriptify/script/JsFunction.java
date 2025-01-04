package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.graalvm.polyglot.proxy.ProxyExecutable;
import org.graalvm.polyglot.Value;

public class JsFunction implements ProxyExecutable {

    private final Script<?> script;
    private final ScriptFunction function;

    public JsFunction(Script<?> script, ScriptFunction function) {
        this.script = script;
        this.function = function;
    }

    @Override
    public Object execute(Value... arguments) {
        ScriptFunctionArgument[] args = new ScriptFunctionArgument[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            args[i] = ScriptFunctionArgument.of(arguments[i].as(Object.class));
        }
        try {
            return function.invoke(script, args);
        } catch (ScriptFunctionException e) {
            throw new RuntimeException(e);
        }
    }
}
