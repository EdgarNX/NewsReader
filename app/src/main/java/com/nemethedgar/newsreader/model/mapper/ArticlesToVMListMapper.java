package com.nemethedgar.newsreader.model.mapper;

import com.nemethedgar.data.news.model.Article;
import com.nemethedgar.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;


public class ArticlesToVMListMapper implements io.reactivex.functions.Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> vmItems = new ArrayList<>();

        for (Article dataItem : articles) {
            ArticleItemViewModel viewModelItem = new ArticleItemViewModel(dataItem.title, dataItem.content, dataItem.imageUrl);

            vmItems.add(viewModelItem);
        }

        return vmItems;
    }
}
