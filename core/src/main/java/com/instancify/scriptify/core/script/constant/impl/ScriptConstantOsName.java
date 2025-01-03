package com.instancify.scriptify.core.script.constant.impl;

import com.instancify.scriptify.api.script.constant.ScriptConstant;

/**
 * Represents a constant with os name
 */
public class ScriptConstantOsName implements ScriptConstant {

    @Override
    public String getName() {
        return "osName";
    }

    @Override
    public Object getValue() {
        return System.getProperty("os.name");
    }
}
