package com.nemethedgar.newsreader.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void refresh() {
        if (newsList.isEmpty()) {
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
            newsList.add(new ArticleItemViewModel());
        }
    }

}
