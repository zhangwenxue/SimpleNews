package com.sharenews.internal.http;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpParams {
    private HashMap<String, String> params = new HashMap<>();

    public HttpParams() {
        addPublicParams(params);
    }


    public void addParam(String key, String value) {
        params.put(key, value);
    }

    public void addParams(Map<String, String> map) {
        if (map != null) {
            params.putAll(map);
        }
    }

    public Map<String, String> getParams() {
        return params;
    }


    private static HashMap<String, String> trim(HashMap<String, String> realParams) {
        Iterator<String> iterator = realParams.keySet().iterator();
        while (iterator.hasNext()) {
            if (realParams.get(iterator.next()) == null) {
                iterator.remove();
            }
        }
        return realParams;
    }

    public static class Builder {
        HashMap<String, String> map = new HashMap<>();

        public Builder() {
            addPublicParams(map);
        }

        public Builder addParam(String key, String value) {
            map.put(key, value);
            return this;
        }

        public Builder addParams(Map<String, String> params) {
            if (map != null) {
                map.putAll(params);
            }
            return this;
        }

        public Map<String, String> build() {
            return map;
        }
    }

    private static void addPublicParams(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
       /* final String tvId = "";
        final String appKey = KookongSDK.getAppKey();
        map.put(ApiConstants.PARAM_SDK_SECRET, appKey);
        map.put(ApiConstants.PARAM_SOURCE, Constants.URL_VALUE_SOURCE);
        map.put(ApiConstants.PARAM_SDK_VERSION, String.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put(ApiConstants.PARAM_VERSION, String.valueOf(TmAppInfo.APP_VERCODE));
        map.put(ApiConstants.PARAM_PACKAGE, TmAppInfo.APP_PACKAGE);
        map.put(ApiConstants.PARAM_PLATFORM, "android");
        map.put(ApiConstants.PARAM_CV, "2");
        map.put(ApiConstants.PARAM_IMEI, TmAppInfo.TV_DEVICEID);
        map.put(ApiConstants.PARAM_PHONE_MODEL, android.os.Build.MODEL);
        map.put(ApiConstants.PARAM_MANUFACTURER, android.os.Build.MANUFACTURER);
        map.put(ApiConstants.PARAM_SDK_VERSION_CODE, String.valueOf(TmAppInfo.SDK_VERCODE));
        map.put(ApiConstants.PARAM_TV_MANUFACTURER, String.valueOf(TmAppInfo.SDK_MANUFID));
        map.put(ApiConstants.PARAM_TV_ID, tvId);*/
    }

}
