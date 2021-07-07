package com.nemethedgar.data.features.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public final String imageUrl;

    public final String title;

    public final String content;

    public final String description;

    public NewsEntity(String imageUrl, String title, String content, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }

}