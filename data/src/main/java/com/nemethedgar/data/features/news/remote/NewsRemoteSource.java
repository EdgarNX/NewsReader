package com.nemethedgar.data.features.news.remote;

import com.nemethedgar.data.features.news.model.Article;
import com.nemethedgar.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.nemethedgar.data.remote.NewsApi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "7e184e14d0b24f47a99a8b568befa8a1";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(@NotNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .map(new NewsDtoToNewsMapper())
                .subscribeOn(Schedulers.io());
    }

}
