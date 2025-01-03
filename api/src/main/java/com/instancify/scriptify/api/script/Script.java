package com.instancify.scriptify.api.script;

import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;

/**
 * Defines the structure of a script that can be executed.
 */
public interface Script {

    /**
     * Sets the function manager for this script.
     *
     * @param functionManager The manager handling script functions
     * @see ScriptFunctionManager
     */
    void setFunctionManager(ScriptFunctionManager functionManager);

    /**
     * Sets the constant manager for this script
     *
     * @param constantManager The manager handling script constants
     * @see ScriptConstantManager
     */
    void setConstantManager(ScriptConstantManager constantManager);

    /**
     * Evaluates and executes this script.
     */
    void eval();
}
