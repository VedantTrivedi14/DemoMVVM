package com.tatvasoftassignment.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tatvasoftassignment.newsapp.R;
import com.tatvasoftassignment.newsapp.databinding.ListItemBinding;
import com.tatvasoftassignment.newsapp.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.binding.txtNews.setText(article.getTitle());
        Glide.with(context).load(article.getUrlToImage())
                .into(holder.binding.imgNews);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding binding;
        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
