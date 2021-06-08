package com.nemethedgar.newsreader.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.newsreader.model.mapper.ArticlesToVMListMapper;
import com.nemethedgar.newsreader.reactive.SingleLiveEvent;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsReaderViewModel extends AndroidViewModel implements LifecycleObserver {

    @NonNull
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    public ObservableList<ArticleItemViewModel> items;

    public NewsReaderViewModel(@NonNull @NotNull Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
        this.items = new ObservableArrayList<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        repo.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        this.items.addAll(articles);
//        isLoading.set(false);
//        resultText.set(getApplication().getString(R.string.results, articles.size()));
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

}
