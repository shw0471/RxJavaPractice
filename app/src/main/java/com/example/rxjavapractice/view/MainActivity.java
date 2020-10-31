package com.example.rxjavapractice.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.rxjavapractice.R;
import com.example.rxjavapractice.databinding.ActivityMainBinding;
import com.example.rxjavapractice.viewModel.GithubRepoListViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        GithubRepoListViewModel githubRepoListViewModel = new GithubRepoListViewModel();
        binding.setViewModel(githubRepoListViewModel);

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etSearch.getText().toString().length() > 0) {
                    githubRepoListViewModel.getGithubRepo(binding.etSearch.getText().toString());
                }
            }
        });
    }
}