package com.sharenews.internal.http;

import com.sharenews.internal.bean.JuheNews;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 红外接口
 */
public interface ServiceApi {

    /**
     * 新闻接口
     *
     * @param map params
     * @return Call<JuheNews>
     */
    @POST(value = ApiConstants.API_NES)
    Call<HttpResponse<JuheNews>> getNews(@QueryMap Map<String, String> map);
}
