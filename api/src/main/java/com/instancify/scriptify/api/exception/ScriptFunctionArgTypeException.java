package com.instancify.scriptify.api.exception;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Exception for script function argument type mismatches.
 */
@Deprecated
public class ScriptFunctionArgTypeException extends ScriptFunctionException {

    /**
     * Creates an exception when argument types don't match.
     *
     * @param required The expected type
     * @param provided The type that was given
     */
    public ScriptFunctionArgTypeException(Class<?> required, Class<?> provided) {
        super("Required argument type: " + required + ", passed: " + provided);
    }

    /**
     * Creates an exception when argument types don't match.
     *
     * @param required The expected types
     * @param provided The type that was given
     */
    public ScriptFunctionArgTypeException(Collection<Class<?>> required, Class<?> provided) {
        super("Required argument types: " + createRequiredClassNames(required) + ", passed: " + provided);
    }

    private static String createRequiredClassNames(Collection<Class<?>> required) {
        return required.stream().map(Class::getName).collect(Collectors.joining(" or "));
    }
}
