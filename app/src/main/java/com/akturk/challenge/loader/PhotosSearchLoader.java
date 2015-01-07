package com.akturk.challenge.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.akturk.challenge.helper.PxPostRequestBuilder;
import com.akturk.challenge.provider.PxApiProvider;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

public class PhotosSearchLoader extends AsyncTaskLoader<JSONObject> {
    public static final int ID = 0;

    public PhotosSearchLoader(Context context) {
        super(context);
    }

    @Override
    public JSONObject loadInBackground() {
        ArrayList<BasicNameValuePair> params =
                new PxPostRequestBuilder()
                        .add("name", "bike")
                        .add("description", "motorcycle")
                        .add("privacy", "1")
                        .build();

        return PxApiProvider.getInstance().post("/photos", params);
    }
}
