package com.instancify.scriptify.api.script;

import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;

/**
 * Defines the structure of a script that can be executed.
 */
public interface Script {

    /**
     * Retrieves the function manager associated with this script.
     *
     * @return The ScriptFunctionManager for this script
     * @see ScriptFunctionManager
     */
    ScriptFunctionManager getFunctionManager();

    /**
     * Sets the function manager for this script.
     *
     * @param functionManager The manager handling script functions
     * @see ScriptFunctionManager
     */
    void setFunctionManager(ScriptFunctionManager functionManager);

    /**
     * Retrieves the constant manager associated with this script.
     *
     * @return The ScriptConstantManager for this script
     * @see ScriptConstantManager
     */
    ScriptConstantManager getConstantManager();

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
