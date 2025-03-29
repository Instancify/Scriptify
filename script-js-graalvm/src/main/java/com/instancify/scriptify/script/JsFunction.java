package com.instancify.scriptify.script;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyExecutable;

import java.util.ArrayList;
import java.util.List;

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
            args[i] = ScriptFunctionArgument.of(convertValue(arguments[i]));
        }
        try {
            return function.invoke(script, args);
        } catch (ScriptFunctionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts the Value object to the appropriate Java type.
     */
    private Object convertValue(Value value) {
        if (value.isNull()) {
            return null;
        } else if (value.hasArrayElements()) {
            List<Object> list = new ArrayList<>();
            for (long j = 0; j < value.getArraySize(); j++) {
                list.add(convertValue(value.getArrayElement(j)));
            }
            return list;
        } else if (value.isHostObject()) {
            return value.asHostObject();
        } else if (value.isString()) {
            return value.asString();
        } else if (value.isBoolean()) {
            return value.asBoolean();
        } else if (value.isNumber()) {
            return value.as(Number.class);
        } else {
            return value.as(Object.class);
        }
    }
}
