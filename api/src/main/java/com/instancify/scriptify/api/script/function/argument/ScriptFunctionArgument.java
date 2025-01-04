package com.instancify.scriptify.api.script.function.argument;

/**
 * Represents an argument that can be passed to a script function.
 */
public interface ScriptFunctionArgument {

    /**
     * Retrieves the value of this argument.
     *
     * @return The value of the argument
     */
    Object getValue();

    /**
     * Checks if the value of this argument is an instance of the specified class.
     *
     * @param classOf The class to check against
     * @return true if the value is an instance of the given class, false otherwise
     */
    default boolean is(Class<?> classOf) {
        return classOf.isInstance(getValue());
    }

    /**
     * Casts the value of this argument to the specified class type.
     *
     * @param <T> The type to cast to
     * @param classOf The class representing the type to cast to
     * @return The value cast to the specified type
     * @throws ClassCastException if the value cannot be cast to the specified type
     */
    default <T> T as(Class<T> classOf) {
        return classOf.cast(getValue());
    }

    /**
     * Creates a new ScriptFunctionArgument with the given value.
     *
     * @param value The value to be wrapped as an argument
     * @return A new ScriptFunctionArgument instance
     */
    static ScriptFunctionArgument of(Object value) {
        return () -> value;
    }
}