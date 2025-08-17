package com.instancify.scriptify.common.script.constant.impl;

import com.instancify.scriptify.api.script.constant.ScriptConstant;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a constant with os name
 */
public class ScriptConstantOsName implements ScriptConstant {

    @Override
    public @NotNull String getName() {
        return "osName";
    }

    @Override
    public Object getValue() {
        return System.getProperty("os.name");
    }
}
