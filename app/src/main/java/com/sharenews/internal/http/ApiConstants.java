package com.sharenews.internal.http;


public interface ApiConstants {
    String BASE_URL = "http://v.juhe.cn/";
    String API_NES = "toutiao/index";

    interface paramKey {
        String PARAMS_NEWS_KEY = "key";
        String PARAM_NEWS_TYPE = "type";
    }

    interface paramValue {
        String NEWS_TOP = "top";
        String NEWS_SOCIETY = "shehui";
        String NEWS_INTERNAL = "guonei";
        String NEWS_INTERNATIONAL = "guoji";
        String NEWS_ENTERTAINMENT = "yule";
        String NEWS_SPORTS = "tiyu";
        String NEWS_MILITARY = "junshi";
        String NEWS_TECHNOLOGY = "keji";
        String NEWS_BUSINESS = "caijing";
        String NEWS_FASHION = "shishang";
    }
}
