package com.akturk.challenge.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import com.akturk.challenge.model.Category;

import java.util.List;

public class HomeListAdapter extends ArrayAdapter<Category> {

    public HomeListAdapter(Context context, List<Category> objects) {
        super(context, View.NO_ID, objects);
    }

}
