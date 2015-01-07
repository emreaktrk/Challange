package com.akturk.challenge.event;

import org.json.JSONObject;

public final class PhotosSearchEvent {
    private JSONObject mResponse;

    public PhotosSearchEvent() {
    }

    public PhotosSearchEvent(JSONObject result) {
        mResponse = result;
    }

    public JSONObject getResponse() {
        return mResponse;
    }

    public void setResponse(JSONObject response) {
        mResponse = response;
    }
}
