package com.instancify.scriptify.core.script.function.definition.factory;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.definition.ScriptFunctionDefinition;
import com.instancify.scriptify.api.script.function.definition.factory.ScriptFunctionDefinitionFactory;
import com.instancify.scriptify.core.script.function.definition.ScriptFunctionDefinitionImpl;

public class StandardFunctionDefinitionFactory implements ScriptFunctionDefinitionFactory {

    @Override
    public ScriptFunctionDefinition create(ScriptFunction function) {
        return new ScriptFunctionDefinitionImpl(function);
    }
}
