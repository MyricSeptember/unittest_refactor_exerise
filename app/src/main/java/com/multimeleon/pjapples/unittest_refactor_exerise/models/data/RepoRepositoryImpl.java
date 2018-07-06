package com.multimeleon.pjapples.unittest_refactor_exerise.models.data;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.GithubRepoRestService;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.response.SearchResponse;

import retrofit2.Call;

public class RepoRepositoryImpl implements RepoRepository {

    private GithubRepoRestService githubRepoRestService;

    public RepoRepositoryImpl(GithubRepoRestService githubRepoRestService) {
        this.githubRepoRestService = githubRepoRestService;
    }

    @Override
    public Call<SearchResponse> searchUsers(String searchTerm) {


        return githubRepoRestService.searchRepos(searchTerm);


    }

}
