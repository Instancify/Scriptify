package com.instancify.scriptify.core.script.function.impl.random;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Represents a function to generate random long number
 */
public class ScriptFunctionRandomLong implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "randomLong";
    }

    @Override
    public Object invoke(Script<?> script, Object[] args) throws ScriptFunctionException {
        Random random = new Random();
        if (args.length > 2 || args.length < 1) throw new ScriptFunctionArgsCountException(1, args.length);

        if (args.length == 1) {
            if (args[0] instanceof Number max) {
                return random.nextLong(max.longValue());
            } else {
                throw new ScriptFunctionArgTypeException(Number.class, args[0].getClass());
            }
        }

        if (args[0] instanceof Number min) {
            if (args[1] instanceof Number max) {
                return random.nextLong(max.longValue() - min.longValue()) + min.longValue();
            } else {
                throw new ScriptFunctionArgTypeException(Number.class, args[1].getClass());
            }
        } else {
            throw new ScriptFunctionArgTypeException(Number.class, args[0].getClass());
        }
    }
}
