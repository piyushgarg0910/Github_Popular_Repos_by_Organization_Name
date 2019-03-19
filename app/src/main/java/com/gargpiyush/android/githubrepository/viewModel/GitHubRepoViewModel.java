package com.gargpiyush.android.githubrepository.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gargpiyush.android.githubrepository.model.OrgRepos;
import com.gargpiyush.android.githubrepository.repository.GitHubRepo;

/**
 * Created by Piyush Garg on 3/18/2019 at 21:47.
 */
public class GitHubRepoViewModel extends AndroidViewModel {

    private Application application;
    private GitHubRepo gitHubRepo = new GitHubRepo();

    public GitHubRepoViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<OrgRepos> getGitHubOrgRepo(String query){
        return gitHubRepo.getRepoResult(query);
    }
}
