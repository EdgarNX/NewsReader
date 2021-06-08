package com.nemethedgar.data;

import com.nemethedgar.data.news.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {

    @NotNull
    Single<List<Article>> getNewsArticles();

}
