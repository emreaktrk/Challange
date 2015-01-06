package com.akturk.challenge.model;

import com.google.gson.annotations.SerializedName;

public final class User {
    @SerializedName("firstname")
    private String mFirstname;
    
    @SerializedName("lastname")
    private String mLastname;

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        mLastname = lastname;
    }
}
