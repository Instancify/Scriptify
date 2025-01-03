package com.instancify.scriptify.core.script.function.impl.crypto;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Represents a function to generate md5 hash for string
 */
public class ScriptFunctionMD5 implements ScriptFunction {
    @Override
    public String getName() {
        return "md5";
    }

    @Override
    public Object invoke(Script script, Object[] args) throws ScriptFunctionException {
        if (args.length != 1) {
            throw new ScriptFunctionArgsCountException(1, args.length);
        }

        if (!(args[0] instanceof String input)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new ScriptFunctionException(e);
        }
    }
}
