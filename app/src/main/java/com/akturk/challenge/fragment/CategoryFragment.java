package com.akturk.challenge.fragment;

import android.support.annotation.NonNull;
import android.widget.ListView;

import com.akturk.challenge.R;
import com.akturk.challenge.adapter.HomeListAdapter;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.event.LoginSuccessEvent;
import com.akturk.challenge.model.Category;
import com.akturk.challenge.task.PhotosSearchTask;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.InjectView;

public final class CategoryFragment extends BaseFragment {

    @InjectView(R.id.fragment_category_listview)
    protected ListView mList;

    private HomeListAdapter mAdapter;

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_category;
    }

    @Subscribe
    public void onLoginSuccessEvent(LoginSuccessEvent event) {
        Category category = new Category();
        category.setName("Bike");

        ArrayList<Category> list = new ArrayList<>();
        list.add(category);

        mAdapter = new HomeListAdapter(getContext(), list);
        mList.setAdapter(mAdapter);
    }

}
