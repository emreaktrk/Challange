package com.akturk.challenge.event;

import com.akturk.challenge.model.Category;

public abstract class CategorySelectedEvent {
    private Category mCategory;

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        this.mCategory = category;
    }
}
