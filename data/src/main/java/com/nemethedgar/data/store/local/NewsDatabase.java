package com.nemethedgar.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.nemethedgar.data.features.news.local.NewsDao;
import com.nemethedgar.data.features.news.local.NewsEntity;

@Database(entities = {NewsEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();
}
