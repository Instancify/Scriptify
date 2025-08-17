package com.instancify.scriptify.api.script.function;

import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a function that can be used within scripts.
 */
public interface ScriptFunction {

    /**
     * Gets the name of the function.
     *
     * @return The function's name
     */
    @NotNull String getName();

    /**
     * Invokes the function with the provided arguments.
     *
     * @param script The script in which the function will be invoked
     * @param args The arguments to pass to the function
     * @return The result of the function execution
     * @throws ScriptFunctionException If there's an error during invocation
     */
    @Deprecated
    default @Nullable Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        return null;
    }
}
