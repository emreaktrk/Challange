package com.akturk.challenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akturk.challenge.R;
import com.akturk.challenge.model.Photo;
import com.akturk.challenge.view.SquaredImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public final class PictureGridAdapter extends ArrayAdapter<Photo> {

    public PictureGridAdapter(Context context, List<Photo> objects) {
        super(context, View.NO_ID, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell_picture, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        Photo photo = getItem(position);
        Picasso.with(getContext()).load(photo.getUrl()).fit().into(viewHolder.mImageView);

        viewHolder.mTextView.setText(photo.getName());

        return convertView;
    }

    protected static final class ViewHolder {

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }

        @InjectView(R.id.cell_picture_imageview)
        SquaredImageView mImageView;

        @InjectView(R.id.cell_picture_textview)
        TextView mTextView;
    }
}
