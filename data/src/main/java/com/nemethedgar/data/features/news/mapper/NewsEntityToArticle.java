package com.nemethedgar.data.features.news.mapper;

import com.nemethedgar.data.features.news.local.NewsEntity;
import com.nemethedgar.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsEntityToArticle implements Function<List<NewsEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<NewsEntity> articles) {
        List<Article> newsReaderEntities = new ArrayList<>();

        for (NewsEntity article : articles) {
            Article newsReaderEntity = new Article(
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
