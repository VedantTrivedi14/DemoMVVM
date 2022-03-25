package com.tatvasoftassignment.newsapp.retrofit;

import static com.tatvasoftassignment.newsapp.utils.Constant.API_KEY;

import com.tatvasoftassignment.newsapp.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("top-headlines?country=in&category=business&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadlines();

}
