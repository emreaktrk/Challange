package com.akturk.challenge.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.annotation.NonPersistent;
import com.akturk.challenge.annotation.Persistent;
import com.akturk.challenge.event.CategorySelectedOnPhoneEvent;
import com.akturk.challenge.fragment.CategoryFragment;
import com.akturk.challenge.fragment.PictureFragment;
import com.fivehundredpx.api.FiveHundredException;
import com.fivehundredpx.api.auth.AccessToken;
import com.fivehundredpx.api.tasks.XAuth500pxTask;
import com.squareup.otto.Subscribe;


public final class HomeActivity extends BaseActivity implements XAuth500pxTask.Delegate {

    @Persistent
    private CategoryFragment mCategoryFragment;

    @NonPersistent
    private PictureFragment mPictureFragment;

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.layout_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();

        mCategoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentById(R.id.layout_home_container_category);
        mPictureFragment = (PictureFragment) getSupportFragmentManager().findFragmentById(R.id.layout_home_container_picture);
    }

    @Subscribe
    public void OnCategorySelectedOnPhoneEvent(CategorySelectedOnPhoneEvent event) {
        // TODO Start picture activity
        // TODO Load items
    }

    @Override
    public void onSuccess(AccessToken result) {

    }

    @Override
    public void onFail(FiveHundredException e) {

    }
}
