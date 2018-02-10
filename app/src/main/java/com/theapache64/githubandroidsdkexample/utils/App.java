package com.theapache64.githubandroidsdkexample.utils;

import android.app.Application;

import com.theapache64.github_android_sdk.GitHubAPI;

/**
 * Created by theapache64 on 8/2/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GitHubAPI.init(SecretConstants.GITHUB_ACCESS_TOKEN);
    }
}
