package com.sharenews.internal.http.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class PublicParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl httpUrl = original.url();
        //添加请求头
        Request request = original.newBuilder()
                //.addHeader("Accept-Encoding", "identity")
                .addHeader("Connection", "keep-alive")
                //.addHeader("User-Agent", System.getProperty("http.agent").replace("Dalvik", "Dalv1k"))
                .method(original.method(), original.body())
                .url(httpUrl)
                .build();
        return chain.proceed(request);
    }
}
