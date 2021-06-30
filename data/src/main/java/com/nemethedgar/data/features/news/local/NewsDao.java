package com.nemethedgar.data.features.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    Single<List<NewsEntity>> queryArticles();

    @Query("SELECT * FROM news where id= :id")
    Single<NewsEntity> queryArticleItem(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<NewsEntity> Articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(NewsEntity article);

    @Query("UPDATE news SET title = :title, content = :content, imageURL = :imageURL where id=:id")
    Completable updateProfile(String title, String content, String imageURL, int id);
}
