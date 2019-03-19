package com.gargpiyush.android.githubrepository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piyush Garg on 3/17/2019 at 21:03.
 */
public class RepoLicense {

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("spdx_id")
    private String spdx_id;

    @SerializedName("url")
    private String url;

    @SerializedName("node_id")
    private String node_id;

    public RepoLicense(String key, String name, String spdx_id, String url, String node_id) {
        this.key = key;
        this.name = name;
        this.spdx_id = spdx_id;
        this.url = url;
        this.node_id = node_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdx_id() {
        return spdx_id;
    }

    public void setSpdx_id(String spdx_id) {
        this.spdx_id = spdx_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}