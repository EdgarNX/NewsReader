package com.nemethedgar.data.features.news.mapper;

import com.nemethedgar.data.features.news.local.NewsEntity;
import com.nemethedgar.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsArticlesToEntity implements Function<List<Article>, List<NewsEntity>> {

    @Override
    public List<NewsEntity> apply(List<Article> articles) {
        List<NewsEntity> newsReaderEntities = new ArrayList<>();

        for (Article article : articles) {
            NewsEntity newsReaderEntity = new NewsEntity(
                    article.imageUrl != null ? article.imageUrl : "", //Adding default values for business model
                    article.title != null ? article.title : "",
                    article.content != null ? article.content : "",
                    article.description != null ? article.description : ""
            );

            newsReaderEntities.add(newsReaderEntity);
        }

        return newsReaderEntities;
    }
}
