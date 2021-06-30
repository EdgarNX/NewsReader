package com.nemethedgar.data.features.news.local;

import com.nemethedgar.data.features.news.mapper.NewsArticlesToEntity;
import com.nemethedgar.data.features.news.mapper.NewsEntityToArticle;
import com.nemethedgar.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalDataStore {

    private static NewsDao dao;

    public NewsLocalDataStore(NewsDao dao) {
        this.dao = dao;
    }

    public static Single<List<Article>> getNewsReaderList() {
        return dao.queryArticles().map(new NewsEntityToArticle());
    }

    public static void saveArticles(List<Article> articles) throws Exception {
        Single.just(articles).map(new NewsArticlesToEntity())
                .flatMapCompletable((newsReaderEntities -> dao.insertArticles(newsReaderEntities)))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public Single<NewsEntity> getNewsReaderItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteNewsReaderItem(int id) {
        return dao.deleteArticleItem(id);
    }

    public Completable saveArticle(NewsEntity newsReaderEntity) {
        if (newsReaderEntity.id == null) {
            return dao.insertArticle(newsReaderEntity);
        } else {
            return dao.updateProfile(newsReaderEntity.title, newsReaderEntity.content, newsReaderEntity.imageUrl, newsReaderEntity.id);
        }
    }
}
