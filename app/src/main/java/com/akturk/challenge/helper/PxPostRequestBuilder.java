package com.akturk.challenge.helper;


import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class PxPostRequestBuilder {
    ArrayList<BasicNameValuePair> mListParams;

    public PxPostRequestBuilder() {
        mListParams = new ArrayList<>();
    }

    public PxPostRequestBuilder add(String param, String value) {
        BasicNameValuePair pair = new BasicNameValuePair(param, value);
        mListParams.add(pair);

        return this;
    }

    public ArrayList<BasicNameValuePair> build() {
        return mListParams;
    }

}
