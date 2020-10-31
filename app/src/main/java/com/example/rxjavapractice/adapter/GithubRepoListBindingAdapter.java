package com.example.rxjavapractice.adapter;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavapractice.model.GithubRepo;

import java.util.List;

public class GithubRepoListBindingAdapter {
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, MutableLiveData<List<GithubRepo>> githubRepoList) {
        GithubRepoListAdapter adapter = new GithubRepoListAdapter();
        recyclerView.setAdapter(adapter);

        if (githubRepoList == null) return;
        adapter.setList(githubRepoList.getValue());
    }
}
