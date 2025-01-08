package com.instancify.scriptify.api.script.security;

import java.util.Set;

/**
 * Manages class access based on security constraints, ensuring only allowed classes can be used.
 */
public interface SecurityClassAccessor {

    /**
     * Retrieves the set of class names that are allowed to be accessed or used.
     *
     * @return A set of strings representing the names of allowed classes
     */
    Set<String> getAllowedClasses();

    /**
     * Adds a class to the list of allowed classes, which can then be used or accessed.
     *
     * @param allowedClass The name of the class to be added to the allowed list
     */
    void addAllowedClass(String allowedClass);
}