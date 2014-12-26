package com.akturk.challenge.fragment;

import android.support.annotation.NonNull;
import android.widget.ListView;

import com.akturk.challenge.R;
import com.akturk.challenge.adapter.HomeListAdapter;

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

}
