package com.nemethedgar.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.data.features.news.NewsRepositoryImpl;
import com.nemethedgar.data.features.news.local.NewsLocalDataStore;
import com.nemethedgar.data.features.news.remote.NewsRemoteSource;
import com.nemethedgar.data.remote.HttpClientFactory;
import com.nemethedgar.data.store.local.NewsDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;

    private volatile NewsDatabase database;

    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideLocalSource(), provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalDataStore provideLocalSource() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.newsDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null)
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class,
                            "news.db")
                            .build();
            }
        }
        return database;
    }

}
