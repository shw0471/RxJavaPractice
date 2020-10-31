package com.example.rxjavapractice.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.rxjavapractice.model.GithubRepo;
import com.example.rxjavapractice.model.GithubRepoModel;

import java.util.List;

public class GithubRepoListViewModel {

    public MutableLiveData<List<GithubRepo>> githubLiveData = new MutableLiveData<>();
    private GithubRepoModel githubRepoModel;

    public GithubRepoListViewModel() {
        githubRepoModel = new GithubRepoModel(githubRepoList -> githubLiveData.setValue(githubRepoList));
    }

    public void getGithubRepo(String userID) {
        githubRepoModel.getUserRepo(userID);
    }
}
