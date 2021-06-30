package com.nemethedgar.data.features.news;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.data.features.news.local.NewsEntity;
import com.nemethedgar.data.features.news.local.NewsLocalDataStore;
import com.nemethedgar.data.features.news.model.Article;
import com.nemethedgar.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRepositoryImpl implements NewsRepository {

    private static final String TAG = NewsRepositoryImpl.class.getName();

    private final NewsLocalDataStore localDataStore;

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsLocalDataStore localDataStore, NewsRemoteSource remoteSource) {
        this.localDataStore = localDataStore;
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(NewsLocalDataStore::saveArticles)
                .onErrorResumeNext(NewsLocalDataStore.getNewsReaderList());
    }

    @androidx.annotation.NonNull
    @Override
    public Single<List<Article>> getArticleList() {
        return localDataStore.getNewsReaderList()
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable saveNewsReaderItem(NewsEntity newsReaderEntity) {
        return localDataStore.saveArticle(newsReaderEntity)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Completable deleteItem(int itemId) {
        return localDataStore.deleteNewsReaderItem(itemId)
                .subscribeOn(Schedulers.io());
    }

    @androidx.annotation.NonNull
    @Override
    public Single<NewsEntity> getArticleItem(int itemId) {
        return localDataStore.getNewsReaderItem(itemId)
                .subscribeOn(Schedulers.io());
    }
}
