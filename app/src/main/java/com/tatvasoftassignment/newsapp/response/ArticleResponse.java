package com.tatvasoftassignment.newsapp.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tatvasoftassignment.newsapp.model.Article;

import java.util.List;

public class ArticleResponse {

    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public String toString() {
        return "BashBoardNewsResponse{"+
                "articles="+articles+'}';
    }
}
