package com.nemethedgar.newsreader.model.factory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.nemethedgar.data.NewsRepository;
import com.nemethedgar.newsreader.DemoApplication;
import com.nemethedgar.newsreader.model.NewsReaderViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsReaderViewModel.class)) {
            NewsRepository repo = DemoApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsReaderViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}