package com.nemethedgar.newsreader.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.nemethedgar.newsreader.view.bindings.ImageBindings;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final String newsTitle;
    public final String newsContent;
    public final String articleImageURL;

    public ArticleItemViewModel(String newsTitle, String newsContent, String articleImageURL) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.articleImageURL = articleImageURL;
    }
}
