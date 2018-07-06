package com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.response.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GithubRepoRestService {
    @Headers({"Accept: application/vnd.github.mercy-preview+json"})
    @GET("search/repositories")
    Call<SearchResponse> searchRepos(@Query("q") String term);
}
