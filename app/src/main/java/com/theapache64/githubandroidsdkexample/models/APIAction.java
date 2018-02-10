package com.theapache64.githubandroidsdkexample.models;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

/**
 * Created by theapache64 on 8/2/18.
 */

public class APIAction {

    @IdRes
    private final int id;

    @StringRes
    private final int title;


    public APIAction(int id, int title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getTitle() {
        return title;
    }
}
