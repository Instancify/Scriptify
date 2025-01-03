package com.instancify.scriptify.core.script.function.impl.file;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

/**
 * Represents a function to join path
 */
public class ScriptFunctionJoinPath implements ScriptFunction {

    @Override
    public String getName() {
        return "joinPath";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        String path = "";
        for(int i = 0; i < args.length; i++) {
            if(args[i] instanceof String segment) {
                if(path.isEmpty()) {
                    path += segment;
                } else {
                    path += '/' + segment;
                }
            } else {
                throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
            }
        }
        return path;
    }
}
