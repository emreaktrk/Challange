package com.akturk.challenge.helper;


import android.support.annotation.NonNull;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class PxGetRequestBuilder {
    private String mRequestUrl;
    private ArrayList<BasicNameValuePair> mListParams;

    public PxGetRequestBuilder() {
        mListParams = new ArrayList<>();
    }

    public PxGetRequestBuilder(@NonNull String requestUrl) {
        mRequestUrl = requestUrl;
    }

    public PxGetRequestBuilder setRequestUrl(String url) {
        mRequestUrl = url;

        return this;
    }

    public PxGetRequestBuilder add(String param, String value) {
        BasicNameValuePair pair = new BasicNameValuePair(param, value);
        mListParams.add(pair);

        return this;
    }

    public String build() {
        String query = mRequestUrl + "?";

        for (BasicNameValuePair pair : mListParams) {
            query.concat(pair.getName());
            query.concat("=");
            query.concat(pair.getValue());
            query.concat("&");
        }

        return query;
    }

}
