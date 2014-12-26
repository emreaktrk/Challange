package com.akturk.challenge.application;

import android.app.Application;

import com.akturk.challenge.R;

public final class ChallengeApplication extends Application {
    private static boolean mTwoPane;

    @Override
    public void onCreate() {
        super.onCreate();

        mTwoPane = getResources().getBoolean(R.bool.two_pane);
    }

    public static boolean isTwoPane() {
        return mTwoPane;
    }
}
