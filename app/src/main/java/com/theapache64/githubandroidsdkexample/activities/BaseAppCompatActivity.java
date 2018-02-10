package com.theapache64.githubandroidsdkexample.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by theapache64 on 8/2/18.
 */

@SuppressLint("Registered")
public class BaseAppCompatActivity extends AppCompatActivity {

    protected void enableBackNavigation() {
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public static void start(Context context, Class<? extends BaseAppCompatActivity> lauchAct) {
        context.startActivity(new Intent(context, lauchAct));
    }
}
