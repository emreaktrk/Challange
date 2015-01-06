package com.akturk.challenge.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.akturk.challenge.R;
import com.akturk.challenge.annotation.NonPersistent;
import com.akturk.challenge.annotation.Persistent;
import com.akturk.challenge.constant.ApplicationConstants;
import com.akturk.challenge.event.CategorySelectedOnPhoneEvent;
import com.akturk.challenge.fragment.CategoryFragment;
import com.akturk.challenge.fragment.PictureFragment;
import com.akturk.challenge.model.User;
import com.fivehundredpx.api.FiveHundredException;
import com.fivehundredpx.api.PxApi;
import com.fivehundredpx.api.auth.AccessToken;
import com.fivehundredpx.api.tasks.UserDetailTask;
import com.fivehundredpx.api.tasks.XAuth500pxTask;
import com.google.gson.Gson;
import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Subscribe;

import org.json.JSONObject;


public final class HomeActivity extends BaseActivity implements XAuth500pxTask.Delegate, UserDetailTask.Delegate {

    @Persistent
    private CategoryFragment mCategoryFragment;

    @NonPersistent
    private PictureFragment mPictureFragment;

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.layout_home;
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();

        mCategoryFragment = (CategoryFragment) getSupportFragmentManager().findFragmentById(R.id.layout_home_container_category);
        mPictureFragment = (PictureFragment) getSupportFragmentManager().findFragmentById(R.id.layout_home_container_picture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XAuth500pxTask task = new XAuth500pxTask(this);
        task.execute(ApplicationConstants.CONSUMER_KEY, ApplicationConstants.CONSUMER_SECRET, "emreaktrk", "Emrebey559876-");
    }

    @Subscribe
    public void OnCategorySelectedOnPhoneEvent(CategorySelectedOnPhoneEvent event) {
        // TODO Start picture activity
        // TODO Load items
    }

    @Override
    public void onSuccess(AccessToken result) {
        PxApi api = new PxApi(result, ApplicationConstants.CONSUMER_KEY, ApplicationConstants.CONSUMER_SECRET);
        UserDetailTask task = new UserDetailTask(this);
        task.execute(api);
    }

    @Override
    public void onFail(FiveHundredException e) {

    }

    @Override
    public void onSuccess(JSONObject response) {
        Gson gson = new Gson();
        User user = gson.fromJson(response.toString(), User.class);

        String text = "You have logged as " + user.getFirstname() + " " + user.getLastname();
        Snackbar.with(this)
                .text(text)
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .show(this);
    }

    @Override
    public void onFail() {

    }
}
