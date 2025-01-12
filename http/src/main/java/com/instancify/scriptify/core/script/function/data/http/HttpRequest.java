package com.instancify.scriptify.core.script.function.data.http;

import okhttp3.*;

import java.io.IOException;

public class HttpRequest {
    private final String url;
    private final String method;
    private String body = "";
    private String mediaType = "";

    public HttpRequest(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public void setBody(String body, String mediaType) {
        this.body = body;
        this.mediaType = mediaType;
    }

    public String send() {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);

        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {

            if (body != null && !body.isEmpty()) {
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
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                return responseBody.string();
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
