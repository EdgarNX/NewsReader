package com.nemethedgar.newsreader.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nemethedgar.newsreader.R;
import com.nemethedgar.newsreader.databinding.NewsItemBinding;
import com.nemethedgar.newsreader.databinding.NewsListFragmentBinding;
import com.nemethedgar.newsreader.model.NewsListViewModel;

import org.jetbrains.annotations.NotNull;

public class NewsListFragment extends Fragment {

    private NewsListViewModel newsListViewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsListViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);

        getLifecycle().addObserver(newsListViewModel);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(newsListViewModel);

        return binding.getRoot();
    }
}