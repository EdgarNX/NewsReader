package com.nemethedgar.newsreader.view.bindings;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nemethedgar.newsreader.adapter.NewsReaderAdapter;
import com.nemethedgar.newsreader.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> article) {
        NewsReaderAdapter articleAdapter = (NewsReaderAdapter) recyclerView.getAdapter();

        if (articleAdapter == null) {
            articleAdapter = new NewsReaderAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(articleAdapter);
        }

        articleAdapter.setItems(article);
    }
}
