package com.tatvasoftassignment.newsapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tatvasoftassignment.newsapp.repository.ArticleRepository;
import com.tatvasoftassignment.newsapp.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

     ArticleRepository articleRepository;
     LiveData<ArticleResponse>  articleResponseLiveData;

    public ArticleViewModel(Application application) {
        super(application);
       articleRepository = new ArticleRepository();
       this.articleResponseLiveData = articleRepository.getDashBoardNews();

    }

    public LiveData<ArticleResponse> getBashBoardNewsResponseLiveData(){
        return articleResponseLiveData;
    }
}
