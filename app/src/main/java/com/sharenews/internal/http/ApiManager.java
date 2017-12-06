package com.sharenews.internal.http;


import com.sharenews.internal.bean.JuheNews;
import com.sharenews.internal.http.converter.FastJsonConverterFactory;
import com.sharenews.internal.http.interceptor.PublicParamsInterceptor;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;


public class ApiManager {
    private volatile static ApiManager instance;
    private ServiceApi mServiceApi;

    private ApiManager() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new PublicParamsInterceptor())
                .build();

        Retrofit mRetrofitClient = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(client)
                .build();
        mServiceApi = mRetrofitClient.create(ServiceApi.class);
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            synchronized (ApiManager.class) {
                if (instance == null) {
                    instance = new ApiManager();
                }
            }
        }
        return instance;
    }


    public Call<HttpResponse<JuheNews>> getNewsAsync(String type, String key, Callback<HttpResponse<JuheNews>> callback) {
        HttpParams params = new HttpParams();
        params.addParam(ApiConstants.paramKey.PARAM_NEWS_TYPE, type);
        params.addParam(ApiConstants.paramKey.PARAMS_NEWS_KEY, key);
        Call<HttpResponse<JuheNews>> call = mServiceApi.getNews(params.getParams());
        call.enqueue(callback);
        return call;
    }

    public HttpResponse<JuheNews> getNewsSync(String type, String key) throws IOException {
        HttpParams params = new HttpParams();
        params.addParam(ApiConstants.paramKey.PARAM_NEWS_TYPE, type);
        params.addParam(ApiConstants.paramKey.PARAMS_NEWS_KEY, key);
        Call<HttpResponse<JuheNews>> call = mServiceApi.getNews(params.getParams());
        retrofit2.Response<HttpResponse<JuheNews>> response = call.execute();

        HttpResponse<JuheNews> kookongResponse = new HttpResponse<>();
        if (response.isSuccessful()) {
            kookongResponse = response.body();
        } else {
            kookongResponse.setMessage(response.errorBody().string());
        }
        return kookongResponse;
    }


}
