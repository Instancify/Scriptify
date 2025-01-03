package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import org.mozilla.javascript.NativeArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a function to shuffle an array
 */
public class ScriptFunctionShuffleArray implements ScriptFunction {

    @Override
    public String getName() {
        return "shuffleArray";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0] instanceof NativeArray array)) {
            throw new ScriptFunctionArgTypeException(NativeArray.class, args[0].getClass());
        }

        List<?> list = new ArrayList<Object>(array);
        Collections.shuffle(list);

        return list;
    }
}
