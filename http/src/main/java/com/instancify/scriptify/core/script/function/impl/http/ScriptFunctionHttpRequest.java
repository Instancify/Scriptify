package com.instancify.scriptify.core.script.function.impl.http;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;
import com.instancify.scriptify.api.script.function.argument.ScriptFunctionArgument;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Represents a function to send http request
 */
public class ScriptFunctionHttpRequest implements ScriptFunction {

    @Override
    public @NotNull String getName() {
        return "httpRequest";
    }

    @Override
    public @Nullable Object invoke(Script<?> script, ScriptFunctionArgument[] args) throws ScriptFunctionException {
        if (args.length > 4 || args.length < 2) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }

        if (!(args[0].getValue() instanceof String method)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getType());
        }

        if (!(args[1].getValue() instanceof String url)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getType());
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(url);

        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {

            if (!(args[2].getValue() instanceof String body)) {
                throw new ScriptFunctionArgTypeException(String.class, args[2].getType());
            }

            if (!(args[3].getValue() instanceof String mediaType)) {
                throw new ScriptFunctionArgTypeException(String.class, args[3].getType());
            }

            if (body != null) {
                RequestBody requestBody = RequestBody.create(body, MediaType.get(mediaType));
                requestBuilder
                        .method(method, requestBody);
            } else {
                requestBuilder.method(method, RequestBody.create(new byte[0], null));
            }
        } else {
            requestBuilder.method(method, null);
        }

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(requestBuilder.build()).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
