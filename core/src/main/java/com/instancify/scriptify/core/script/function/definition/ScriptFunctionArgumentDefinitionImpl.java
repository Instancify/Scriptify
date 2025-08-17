package com.instancify.scriptify.core.script.function.definition;

import com.instancify.scriptify.api.script.function.definition.ScriptFunctionArgumentDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ScriptFunctionArgumentDefinitionImpl implements ScriptFunctionArgumentDefinition {
    private final String name;
    private final boolean required;
    private final Class<?> type;
}
