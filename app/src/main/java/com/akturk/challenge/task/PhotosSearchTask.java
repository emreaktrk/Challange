package com.akturk.challenge.task;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.akturk.challenge.constant.RestConstants;
import com.akturk.challenge.event.PhotosSearchEvent;
import com.akturk.challenge.helper.PxGetRequestBuilder;
import com.akturk.challenge.provider.BusProvider;
import com.akturk.challenge.provider.PxApiProvider;

import org.json.JSONObject;

public final class PhotosSearchTask extends AsyncTask<Void, Void, JSONObject> {
    private String mTerm;

    public PhotosSearchTask() {
    }

    public PhotosSearchTask(@NonNull String term) {
        mTerm = term;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        String query = new PxGetRequestBuilder()
                .setRequestUrl(RestConstants.PHOTOS_SEARCH)
                .add("term", mTerm)
                .build();

        return PxApiProvider.getInstance().get(query);
    }

    @Override
    protected void onPostExecute(JSONObject response) {
        if (response == null)
            return;

        PhotosSearchEvent event = new PhotosSearchEvent();
        event.setResponse(response);
        BusProvider.getInstance().post(event);

        super.onPostExecute(response);
    }

    public void setTerm(@NonNull String term) {
        mTerm = term;
    }
}
