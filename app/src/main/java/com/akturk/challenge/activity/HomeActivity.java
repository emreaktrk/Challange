package com.akturk.challenge.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.annotation.NonPersistent;
import com.akturk.challenge.annotation.Persistent;
import com.akturk.challenge.event.CategorySelectedOnPhoneEvent;
import com.akturk.challenge.event.CategorySelectedOnTabletEvent;
import com.akturk.challenge.fragment.CategoryFragment;
import com.akturk.challenge.fragment.PictureFragment;
import com.squareup.otto.Subscribe;


public final class HomeActivity extends BaseActivity {

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

    }

    @Subscribe
    public void OnCategorySelectedOnTabletEvent(CategorySelectedOnTabletEvent event) {
        // TODO Notify the picture fragment

    }


}
