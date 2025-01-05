package com.instancify.scriptify.api.script.security;

import com.instancify.scriptify.api.script.security.exclude.PathSecurityExclude;
import com.instancify.scriptify.api.script.security.exclude.SecurityExclude;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Manages path access based on security constraints, ensuring only safe paths are accessible.
 */
public class SecurityPathAccessor {

    private final ScriptSecurityManager securityManager;
    private Path basePath;

    /**
     * Constructs a SecurityPathAccessor with the default base path set to the current working directory.
     *
     * @param securityManager The security manager to check access permissions
     */
    public SecurityPathAccessor(ScriptSecurityManager securityManager) {
        this(securityManager, Paths.get("").toAbsolutePath());
    }

    /**
     * Constructs a SecurityPathAccessor with a specified base path for relative path calculations.
     *
     * @param securityManager The security manager to check access permissions
     * @param basePath The base path from which relative paths are calculated
     */
    public SecurityPathAccessor(ScriptSecurityManager securityManager, Path basePath) {
        this.securityManager = securityManager;
        this.basePath = basePath;
    }

    /**
     * Gets a base path for this accessor, which will be used for relative path calculations.
     *
     * @return The base path to set
     */
    public Path getBasePath() {
        return basePath;
    }

    /**
     * Sets a new base path for this accessor, which will be used for relative path calculations.
     *
     * @param basePath The new base path to set
     */
    public void setBasePath(Path basePath) {
        this.basePath = basePath;
    }

    /**
     * Returns a path that is safe to access according to security rules. If the path is not accessible,
     * it returns a path relative to the base path with ':' characters removed to prevent potential path traversal attacks.
     *
     * @param path The path string to be checked and possibly modified
     * @return A Path object representing the accessible path or a sanitized version if not accessible
     */
    public Path getAccessiblePath(String path) {
        if (this.isAccessible(path)) {
            return Path.of(path);
        }
        return Path.of(basePath.toString(), path.replaceAll(":", ""));
    }

    /**
     * Checks if the given path is accessible based on the current security settings.
     *
     * @param path The path to check for access permission
     * @return true if the path is accessible, false otherwise
     */
    public boolean isAccessible(String path) {
        if (!securityManager.getSecurityMode()) {
            return true;
        }

        // Search all exclusions and check that the path is excluded
        for (SecurityExclude exclude : securityManager.getExcludes()) {
            if (exclude instanceof PathSecurityExclude) {
                if (exclude.isExcluded(path)) {
                    return true;
                }
            }
        }

        return false;
    }
}
