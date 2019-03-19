package com.gargpiyush.android.githubrepository.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.gargpiyush.android.githubrepository.model.OrgRepos;
import com.gargpiyush.android.githubrepository.network.GitHubRepoAPI;
import com.gargpiyush.android.githubrepository.network.GitHubResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Piyush Garg on 3/18/2019 at 22:16.
 */
public class GitHubRepo {

    private GitHubResponse gitHubResponse;
    private String sort;
    private String order;
    private Integer number;

    public GitHubRepo() {
        sort = "stars";
        order = "desc";
        number = 3;
    }

    public LiveData<OrgRepos> getRepoResult(String query){
        final MutableLiveData<OrgRepos> orgReposMutableLiveData = new MutableLiveData<>();
        gitHubResponse = GitHubRepoAPI.getRetrofitInstance().create(GitHubResponse.class);
        gitHubResponse.getResult("org:"+query,sort,order,number).enqueue(new Callback<OrgRepos>() {
            @Override
            public void onResponse(Call<OrgRepos> call, Response<OrgRepos> response) {
                orgReposMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<OrgRepos> call, Throwable t) {
                Log.e("Failure",t.getMessage());
            }
        });
        return orgReposMutableLiveData;
    }
}
