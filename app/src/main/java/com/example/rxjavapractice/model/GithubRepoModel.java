package com.example.rxjavapractice.model;

import com.example.rxjavapractice.callback.GithubRepoModelListener;

import java.util.ArrayList;
import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepoModel {

    private GithubService githubService;
    private GithubRepoModelListener callback;

    public GithubRepoModel(GithubRepoModelListener callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();
        githubService = retrofit.create(GithubService.class);
        this.callback = callback;
    }

    public void getUserRepo(String userID) {
        githubService.getGithubRepo(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(githubRepo -> {
                    callback.loadList(githubRepo);
                }, e -> {
                    List<GithubRepo> githubRepoList = new ArrayList<>();
                    GithubRepo githubRepo = new GithubRepo();

                    githubRepo.setName("Wrong ID");
                    githubRepo.setCreated_at("please check the Github ID");
                    githubRepoList.add(githubRepo);

                    callback.loadList(githubRepoList);
                });
    }
}