package com.akturk.challenge.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.squareup.otto.Subscribe;

public final class PictureActivity extends BaseActivity {

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.layout_picture;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Subscribe
    public void OnCategorySelectedEvent(CategorySelectedEvent event) {

    }

}
