package com.nemethedgar.newsreader.view.bindings;


import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nemethedgar.newsreader.adapter.NewsReaderAdapter;
import com.nemethedgar.newsreader.model.ArticleItemViewModel;

import java.util.List;

public class ImageBindings {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
