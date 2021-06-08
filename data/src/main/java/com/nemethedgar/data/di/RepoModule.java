package com.nemethedgar.data.di;

import android.app.Application;
import android.content.Context;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.data.news.NewsRepositoryImpl;
import com.nemethedgar.data.news.remote.NewsRemoteSource;
import com.nemethedgar.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
