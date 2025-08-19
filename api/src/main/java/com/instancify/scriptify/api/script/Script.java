package com.instancify.scriptify.api.script;

import com.instancify.scriptify.api.exception.ScriptException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.constant.ScriptConstantManager;
import com.instancify.scriptify.api.script.function.ScriptFunctionManager;
import com.instancify.scriptify.api.script.security.ScriptSecurityManager;

/**
 * Defines the structure of a script that can be executed.
 *
 * @param <T> Type of value returned by the script after evaluation
 */
public interface Script<T> {

    /**
     * Retrieves the security manager associated with this script.
     *
     * @return The ScriptSecurityManager for this script
     * @see ScriptSecurityManager
     */
    ScriptSecurityManager getSecurityManager();

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
     * Add an extra script on top of the whole script.
     *
     * @param script Extra script
     */
    void addExtraScript(String script);

    /**
     * Evaluates and executes this script.
     *
     * @throws ScriptFunctionException If there's an error during script evaluation
     */
    T eval(String script) throws ScriptException;
}
