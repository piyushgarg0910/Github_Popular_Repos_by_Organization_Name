package com.gargpiyush.android.githubrepository.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Piyush Garg on 3/17/2019 at 22:07.
 */
public class GitHubRepoAPI {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.github.com/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
