package com.akturk.challenge.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.akturk.challenge.R;
import com.akturk.challenge.annotation.NonPersistent;
import com.akturk.challenge.annotation.Persistent;
import com.akturk.challenge.constant.ApplicationConstants;
import com.akturk.challenge.event.CategorySelectedOnPhoneEvent;
import com.akturk.challenge.fragment.CategoryFragment;
import com.akturk.challenge.fragment.PictureFragment;
import com.akturk.challenge.model.User;
import com.akturk.challenge.provider.GsonProvider;
import com.akturk.challenge.provider.PxApiProvider;
import com.fivehundredpx.api.FiveHundredException;
import com.fivehundredpx.api.auth.AccessToken;
import com.fivehundredpx.api.tasks.UserDetailTask;
import com.fivehundredpx.api.tasks.XAuth500pxTask;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.squareup.otto.Subscribe;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;


public final class HomeActivity extends BaseActivity implements XAuth500pxTask.Delegate, UserDetailTask.Delegate, ActionClickListener {

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
    public void onSuccess(AccessToken token) {
        PxApiProvider.init(token);

        UserDetailTask task = new UserDetailTask(this);
        task.execute(PxApiProvider.getInstance());
    }

    @Override
    public void onFail(FiveHundredException e) {
        Snackbar.with(this)
                .text("Login failed.")
                .actionLabel("Retry")
                .actionColor(Color.YELLOW)
                .actionListener(this)
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .show(this);
    }

    @Override
    public void onSuccess(JSONObject response) {
        User user = GsonProvider.getInstance().fromJson(response.toString(), User.class);

        CharSequence message = TextUtils.concat("You have logged as ", user.getFirstname(), " ", user.getLastname());
        Snackbar.with(this)
                .text(message)
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .show(this);


        ArrayList<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("term", "bike"));

        JSONObject jsonObject = PxApiProvider.getInstance().get("/photos/search?term=bike");
        String result = jsonObject.toString();
    }

    @Override
    public void onFail() {
        Snackbar.with(this)
                .text("Login failed.")
                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                .show(this);
    }

    @Override
    public void onActionClicked(Snackbar snackbar) {
        XAuth500pxTask task = new XAuth500pxTask(this);
        task.execute(ApplicationConstants.CONSUMER_KEY, ApplicationConstants.CONSUMER_SECRET, "emreaktrk", "Emrebey559876-");
    }
}
