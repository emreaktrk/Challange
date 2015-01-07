package com.akturk.challenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akturk.challenge.R;
import com.akturk.challenge.model.Category;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public final class HomeListAdapter extends ArrayAdapter<Category> {

    public HomeListAdapter(Context context, List<Category> objects) {
        super(context, View.NO_ID, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell_category, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        Category category = getItem(position);
        viewHolder.mNameTextView.setText(category.getName());

        return super.getView(position, convertView, parent);
    }

    protected static final class ViewHolder {
        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }

        @InjectView(R.id.cell_category_name)
        protected TextView mNameTextView;
    }
}
