package com.tatvasoftassignment.newsapp.repository;



import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tatvasoftassignment.newsapp.response.ArticleResponse;
import com.tatvasoftassignment.newsapp.retrofit.ApiRequest;
import com.tatvasoftassignment.newsapp.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {

    private final ApiRequest apiRequest;

    public ArticleRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashBoardNews(){
            final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
            apiRequest.getTopHeadlines().enqueue(new Callback<ArticleResponse>() {
                @Override
                public void onResponse(@NonNull Call<ArticleResponse> call, @NonNull Response<ArticleResponse> response) {
                    if(response.isSuccessful() && response.body() != null){
                        data.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                    data.setValue(null);
                }
            });
            return data;
    }

}
