package com.akturk.challenge.model;


import java.io.Serializable;

public final class Search implements Serializable {

    private String mTerm;

    public Search() {

    }

    public String getTerm() {
        return mTerm;
    }

    public void setTerm(String term) {
        mTerm = term;
    }
}
