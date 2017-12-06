package com.sharenews.internal.http.converter;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.sharenews.internal.http.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;


class GsonResponseConverter<T> implements Converter<ResponseBody, HttpResponse<T>> {

    private ParameterizedType parameterizedType;

    GsonResponseConverter(Type type) {
        parameterizedType = (ParameterizedType) type;
    }

    @Override
    public HttpResponse<T> convert(ResponseBody value) throws IOException {
        assert value != null;
        String content = value.string();
        Type dataType = parameterizedType.getActualTypeArguments()[0];
        HttpResponse<T> result = new HttpResponse<>();
        try {
            JSONObject object = new JSONObject(content);
            result.setCode(object.getInt("error_code"));
            result.setMessage(object.getString("reason"));
            if (result.isDataValid()) {
                JSONObject obj = object.getJSONObject("result");
                if (obj != null) {
                    String data = obj.toString();
                    result.setData((T) new Gson().fromJson(data, dataType));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            result.setCode(-1);
            result.setMessage(e.getMessage());
        }
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(content);
        result.setCode(jsonObject.getInteger("error_code"));
        result.setMessage(jsonObject.getString("reason"));
        return result;
    }


}
