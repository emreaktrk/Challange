package com.akturk.challenge.fragment;

import android.support.annotation.NonNull;
import android.widget.GridView;

import com.akturk.challenge.R;
import com.akturk.challenge.adapter.PictureGridAdapter;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.event.PhotosSearchEvent;
import com.akturk.challenge.model.Category;
import com.akturk.challenge.model.Photo;
import com.akturk.challenge.model.Search;
import com.akturk.challenge.provider.GsonProvider;
import com.akturk.challenge.task.PhotosSearchTask;
import com.squareup.otto.Subscribe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import butterknife.InjectView;

public final class PictureFragment extends BaseFragment {
    private PhotosSearchTask mPhotosSearchTask;

    @InjectView(R.id.fragment_picture_gridview)
    protected GridView mListView;

    public static PictureFragment getInstance(Search search) {
        PictureFragment fragment = new PictureFragment();
        fragment.onCategorySelectedEvent(search);
        return fragment;
    }

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_picture;
    }

    @Subscribe
    public void onCategorySelectedEvent(CategorySelectedEvent event) {
        Category category = event.getCategory();

        mPhotosSearchTask = new PhotosSearchTask();
        mPhotosSearchTask.setTerm(category.getValue());
        mPhotosSearchTask.execute();
    }

    public void onCategorySelectedEvent(Search search) {
        mPhotosSearchTask = new PhotosSearchTask();
        mPhotosSearchTask.setTerm(search.getTerm());
        mPhotosSearchTask.execute();
    }

    @Subscribe
    public void onPhotosSearchEvent(PhotosSearchEvent event) throws JSONException {
        JSONObject serverResponse = event.getResponse();
        JSONArray photosResponse = serverResponse.getJSONArray("photos");

        List<Photo> list = Arrays.asList(GsonProvider.getInstance().fromJson(photosResponse.toString(), Photo[].class));
        PictureGridAdapter adapter = new PictureGridAdapter(getContext(), list);

        mListView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mPhotosSearchTask.cancel(true);
    }
}
