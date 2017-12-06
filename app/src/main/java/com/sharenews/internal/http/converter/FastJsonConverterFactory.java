package com.sharenews.internal.http.converter;


import com.sharenews.internal.http.HttpResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class FastJsonConverterFactory<T> extends Converter.Factory {
    public static FastJsonConverterFactory create() {
        return new FastJsonConverterFactory();
    }


    private FastJsonConverterFactory() {
    }

    @Override
    public Converter<ResponseBody, HttpResponse<T>> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        //TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));

        return new GsonResponseConverter<>(type);
    }
}
