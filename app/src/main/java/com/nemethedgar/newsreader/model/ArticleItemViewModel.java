package com.nemethedgar.newsreader.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.nemethedgar.newsreader.view.bindings.ImageBindings;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final ObservableField<String> newsTitle;
    public final ObservableField<String> newsContent;
    public final String articleImageURL;

    public ArticleItemViewModel() {
        this.newsTitle = new ObservableField<>();
        this.newsContent = new ObservableField<>();
        this.articleImageURL = "https://cdn.pixabay.com/photo/2015/03/26/09/47/sky-690293__340.jpg";
    }
}
