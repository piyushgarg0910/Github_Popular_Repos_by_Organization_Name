package com.gargpiyush.android.githubrepository.network;

import com.gargpiyush.android.githubrepository.model.OrgRepos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Piyush Garg on 3/17/2019 at 21:53.
 */
public interface GitHubResponse {

    @GET("search/repositories")
    Call<OrgRepos> getResult(@Query("q")String OrgName,
                             @Query("sort") String type,
                             @Query("order") String order,
                             @Query("per_page") Integer number);
}
