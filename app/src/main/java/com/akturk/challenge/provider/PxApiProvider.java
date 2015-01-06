package com.akturk.challenge.provider;

import com.akturk.challenge.constant.ApplicationConstants;
import com.akturk.challenge.exception.InitializedException;
import com.akturk.challenge.exception.NotInitException;
import com.fivehundredpx.api.PxApi;
import com.fivehundredpx.api.auth.AccessToken;

public final class PxApiProvider {
    private static PxApi sPxApi;

    public static void init(AccessToken token) {
        if (sPxApi != null)
            throw new InitializedException();

        sPxApi = new PxApi(token, ApplicationConstants.CONSUMER_KEY, ApplicationConstants.CONSUMER_SECRET);
    }

    public static PxApi getInstance() {
        if (sPxApi == null)
            throw new NotInitException();

        return sPxApi;
    }

}
