package com.example.rxjavapractice.callback;

import com.example.rxjavapractice.model.GithubRepo;

import java.util.List;

public interface GithubRepoModelListener {
    void loadList(List<GithubRepo> githubRepoList);
}
