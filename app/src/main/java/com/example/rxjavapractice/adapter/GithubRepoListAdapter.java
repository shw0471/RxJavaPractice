package com.example.rxjavapractice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavapractice.R;
import com.example.rxjavapractice.databinding.ItemGithubRepoBinding;
import com.example.rxjavapractice.model.GithubRepo;

import java.util.ArrayList;
import java.util.List;

public class GithubRepoListAdapter extends RecyclerView.Adapter<GithubRepoListAdapter.ViewHolder> {

    private List<GithubRepo> githubRepoList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_github_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding().setData(githubRepoList.get(position));
    }

    @Override
    public int getItemCount() {
        if (githubRepoList == null) return 0;
        return githubRepoList.size();
    }

    public void setList(List<GithubRepo> githubRepoList) {
        this.githubRepoList = githubRepoList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemGithubRepoBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemGithubRepoBinding binding() {
            return binding;
        }
    }
}