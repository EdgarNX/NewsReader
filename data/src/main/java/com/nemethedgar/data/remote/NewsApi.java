package com.nemethedgar.data.remote;

import androidx.room.Dao;

import com.nemethedgar.data.features.news.remote.model.ArticleListDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Dao
public interface NewsApi {

    @GET("/v2/top-headlines")
    Single<ArticleListDto> getNewsArticles(@Query("apiKey") String apiKey, @Query("language") String language);

}
