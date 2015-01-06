package com.akturk.challenge.provider;

import com.akturk.challenge.constant.RestConstants;
import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public final class RestProvider {

    private static RestAdapter sAdapter;

    public static RestAdapter getInstance() {
        if (sAdapter == null) {
            Gson gson = GsonProvider.getInstance();
            GsonConverter gsonConverter = new GsonConverter(gson);
            sAdapter = new RestAdapter
                    .Builder()
                    .setConverter(gsonConverter)
                    .setEndpoint(RestConstants.ENDPOINT)
                    .build();
        }

        return sAdapter;
    }

}