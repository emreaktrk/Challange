package com.akturk.challenge.event;

import com.akturk.challenge.model.Category;

import java.io.Serializable;

public abstract class CategorySelectedEvent implements Serializable {

    private static final long serialVersionUID = 0L;

    private Category mCategory;

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        this.mCategory = category;
    }
}
