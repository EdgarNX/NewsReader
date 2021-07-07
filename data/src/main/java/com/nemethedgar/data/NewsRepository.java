package com.nemethedgar.data;

import androidx.annotation.NonNull;

import com.nemethedgar.data.features.news.local.NewsEntity;
import com.nemethedgar.data.features.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface NewsRepository {

    @NotNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Single<List<Article>> getArticleList();

    @NonNull
    Single<NewsEntity> getArticleItem(int itemId);

    @NonNull
    Completable saveNewsReaderItem(NewsEntity newsReaders);

    @NonNull
    Completable deleteItem(int itemId);

}
