package com.nemethedgar.newsreader;

import android.app.Application;

import com.nemethedgar.data.di.RepoModule;

public class DemoApplication extends Application {

    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();
        repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoProvider() {
        return repoModule;
    }
}
