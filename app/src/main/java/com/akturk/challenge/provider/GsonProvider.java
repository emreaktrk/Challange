package com.akturk.challenge.provider;

import com.google.gson.Gson;

public final class GsonProvider {

    private static Gson sGson;

    public static Gson getInstance() {
        if (sGson == null)
            sGson = new Gson();

        return sGson;
    }

}