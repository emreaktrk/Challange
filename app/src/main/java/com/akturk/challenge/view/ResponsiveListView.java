package com.akturk.challenge.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.akturk.challenge.application.ChallengeApplication;
import com.akturk.challenge.event.CategorySelectedEvent;
import com.akturk.challenge.event.CategorySelectedOnPhoneEvent;
import com.akturk.challenge.event.CategorySelectedOnTabletEvent;
import com.akturk.challenge.model.Category;
import com.akturk.challenge.provider.BusProvider;

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
        setItemChecked(position, true);

        CategorySelectedEvent event;
        if (ChallengeApplication.isTwoPane())
            event = new CategorySelectedOnTabletEvent();
        else
            event = new CategorySelectedOnPhoneEvent();

        Category category = (Category) getAdapter().getItem(position);
        event.setCategory(category);

        BusProvider.getInstance().post(event);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        if (listener != this)
            throw new IllegalArgumentException("Outer delegation is not allowed.");

        super.setOnItemClickListener(listener);
    }
}
