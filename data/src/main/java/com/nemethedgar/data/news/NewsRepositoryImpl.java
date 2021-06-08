package com.nemethedgar.data.news;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.data.news.model.Article;
import com.nemethedgar.data.news.remote.NewsRemoteSource;
import com.nemethedgar.data.news.remote.mapper.NewsDtoToNewsMapper;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles().map(new NewsDtoToNewsMapper());
    }

}
