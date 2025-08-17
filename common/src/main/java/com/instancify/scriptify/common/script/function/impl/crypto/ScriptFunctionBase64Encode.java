package com.instancify.scriptify.common.script.function.impl.crypto;

import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.annotation.Argument;
import com.instancify.scriptify.api.script.function.annotation.ExecuteAt;
import org.jetbrains.annotations.NotNull;

import java.util.Base64;

/**
 * Represents a function to encode string to base64
 */
public class ScriptFunctionBase64Encode implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "base64encode";
    }

    @ExecuteAt
    public String execute(
            @Argument(name = "string") String string
    ) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }
}
