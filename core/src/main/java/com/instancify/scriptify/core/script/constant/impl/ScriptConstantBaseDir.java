package com.instancify.scriptify.core.script.constant.impl;

import com.instancify.scriptify.api.script.constant.ScriptConstant;

import java.nio.file.Paths;

/**
 * Represents a constant with base dir
 */
public class ScriptConstantBaseDir implements ScriptConstant {

    @Override
    public String getName() {
        return "baseDir";
    }

    @Override
    public Object getValue() {
        return Paths.get("").toAbsolutePath().toString();
    }
}
