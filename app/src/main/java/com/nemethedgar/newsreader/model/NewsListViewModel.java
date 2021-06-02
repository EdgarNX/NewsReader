package com.nemethedgar.newsreader.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import static android.provider.Settings.System.getString;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void refresh() {
        if (newsList.isEmpty()) {
            newsList.add(new ArticleItemViewModel("Unu", "contect content content content content content", "https://st.depositphotos.com/1428083/2946/i/600/depositphotos_29460297-stock-photo-bird-cage.jpg"));
            newsList.add(new ArticleItemViewModel("Trei", "contect content content content content content", "https://thumbs.dreamstime.com/b/environment-earth-day-hands-trees-growing-seedlings-bokeh-green-background-female-hand-holding-tree-nature-field-gra-130247647.jpg"));
            newsList.add(new ArticleItemViewModel("Patru", "contect content content content content content", "https://images.unsplash.com/photo-1590767187868-b8e9ece0974b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8&w=1000&q=80"));
            newsList.add(new ArticleItemViewModel("Cinci", "contect content content content content content", "https://webmeup.com/upload/blog/lead-image-105.png"));
            newsList.add(new ArticleItemViewModel("Sase", "contect content content content content content", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy1uZTBlxjOfVEiZsIt9FSo_bkxgEb6_OslQ&usqp=CAU"));
        }
    }

}
