package com.akturk.challenge.fragment;

import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.event.CategorySelectedOnTabletEvent;
import com.squareup.otto.Subscribe;

public final class PictureFragment extends BaseFragment {

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_picture;
    }

    @Subscribe
    public void OnCategorySelectedOnTabletEvent(CategorySelectedOnTabletEvent event) {
        // TODO Reload items
    }

}
