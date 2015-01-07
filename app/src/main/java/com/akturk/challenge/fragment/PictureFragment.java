package com.akturk.challenge.fragment;

import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.event.CategorySelectedOnTabletEvent;
import com.akturk.challenge.event.PhotosSearchEvent;
import com.akturk.challenge.model.Category;
import com.akturk.challenge.task.PhotosSearchTask;
import com.squareup.otto.Subscribe;

public final class PictureFragment extends BaseFragment {

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_picture;
    }

    @Subscribe
    public void onCategorySelectedEvent(CategorySelectedEvent event) {
        Category category = event.getCategory();

        PhotosSearchTask task = new PhotosSearchTask();
        task.setTerm(category.getName());
        task.execute();
    }

    @Subscribe
    public void onPhotosSearchEvent(PhotosSearchEvent event) {

    }

}
