package com.gargpiyush.android.githubrepository.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Piyush Garg on 3/17/2019 at 20:52.
 */
public class OrgRepos {

    @SerializedName("total_count")
    private Integer total_count;

    @SerializedName("incomplete_results")
    private Boolean incomplete_results;

    @SerializedName("items")
    private ArrayList<Repo> items;

    public OrgRepos(Integer total_count, Boolean incomplete_results, ArrayList<Repo> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public ArrayList<Repo> getItems() {
        return items;
    }

    public void setItems(ArrayList<Repo> items) {
        this.items = items;
    }
}