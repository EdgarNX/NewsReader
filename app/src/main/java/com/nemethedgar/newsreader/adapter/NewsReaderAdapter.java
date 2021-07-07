package com.nemethedgar.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nemethedgar.newsreader.databinding.NewsItemBinding;
import com.nemethedgar.newsreader.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NewsReaderAdapter extends RecyclerView.Adapter<NewsReaderAdapter.ArticleViewHolder> {

    private List<ArticleItemViewModel> articleModelList;

    public NewsReaderAdapter() {
        this.articleModelList = new ArrayList<>();
    }

    public void setItems(List<ArticleItemViewModel> items) {
        this.articleModelList = items;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        NewsItemBinding binder = NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new ArticleViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.binding.setViewModel(articleModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        final NewsItemBinding binding;

        public ArticleViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
