package com.akturk.challenge.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.akturk.challenge.R;
import com.akturk.challenge.constant.DataConstants;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.fragment.PictureFragment;
import com.akturk.challenge.model.Search;
import com.squareup.otto.Subscribe;

public final class PictureActivity extends BaseActivity {
    private Search mSearch;

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.layout_picture;
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSearch = (Search) getIntent().getExtras().get(DataConstants.SEARCH);

        PictureFragment fragment = PictureFragment.getInstance(mSearch);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_picture_container, fragment)
                .commit();
    }

    @Subscribe
    public void OnCategorySelectedEvent(CategorySelectedEvent event) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
