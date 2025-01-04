package com.instancify.scriptify.api.script.security;

import java.nio.file.Path;

public class SecurityPathAccessor {
    private final ScriptSecurityManager securityManager;
    private final Path basePath;

    public SecurityPathAccessor(final ScriptSecurityManager securityManager) {
        this(securityManager, Path.of(""));
    }

    public SecurityPathAccessor(final ScriptSecurityManager securityManager, Path basePath) {
        this.securityManager = securityManager;
        this.basePath = basePath;
    }

    public Path getAccessiblePath(String path) {
        if (isAcessible(path)) {
            return Path.of(path);
        }

        return Path.of(basePath.toString(), path.replaceAll(":\\\\", "/"));
    }

    public boolean isAcessible(String path) {
        /* TODO: Excludes*/
        if (securityManager.getSecurityMode()) {
            return false;
        }
        return true;
    }

}
