package com.tatvasoftassignment.newsapp.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tatvasoftassignment.newsapp.R;
import com.tatvasoftassignment.newsapp.adapter.ArticleAdapter;
import com.tatvasoftassignment.newsapp.databinding.ActivityMainBinding;
import com.tatvasoftassignment.newsapp.model.Article;
import com.tatvasoftassignment.newsapp.viewmodel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final ArrayList<Article> article = new ArrayList<>();
    private ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;
     private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    init();
    getArticles();

    }

    private void init() {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(this,article);
        binding.recyclerView.setAdapter(adapter);
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }
    private void getArticles() {
      articleViewModel.getBashBoardNewsResponseLiveData().observe(this, articleResponse -> {
                if(articleResponse != null && articleResponse.getArticles()!= null && !articleResponse.getArticles().isEmpty()) {
                        binding.progressBar.setVisibility(View.GONE);
                        List<Article> articles = articleResponse.getArticles();
                        article.addAll(articles);
                        adapter.notifyDataSetChanged();

                }
      });
    }
}