package com.theapache64.githubandroidsdkexample.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import com.afollestad.materialdialogs.MaterialDialog;
import com.theapache64.githubandroidsdkexample.R;


/**
 * Created by theapache64 on 15/9/17.
 */

public class DialogUtils {

    private final Context context;

    public DialogUtils(Context context) {
        this.context = context;
    }

    public MaterialDialog getProgressDialog(@StringRes int message) {
        return new MaterialDialog.Builder(context)
                .content(message)
                .progress(true, 0)
                .build();
    }

    public void showErrorDialog(@StringRes int message) {
        showErrorDialog(context.getString(message));
    }

    public void showErrorDialog(String message) {
        new MaterialDialog.Builder(context)
                .title(R.string.Error)
                .content(message)
                .positiveText(R.string.OK)
                .build().show();
    }

    public void showSimpleDialog(@StringRes int title, @StringRes int message) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(message)
                .positiveText(R.string.OK)
                .build()
                .show();
    }

}
