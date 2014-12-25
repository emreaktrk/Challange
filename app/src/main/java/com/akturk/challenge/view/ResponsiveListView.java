package com.akturk.challenge.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public final class ResponsiveListView extends ListView implements AdapterView.OnItemClickListener {

    public ResponsiveListView(Context context) {
        super(context);

        if (!isInEditMode())
            init();
    }

    public ResponsiveListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            init();

    }

    public ResponsiveListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            init();

    }

    private void init() {
        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
