package com.multimeleon.pjapples.unittest_refactor_exerise.models.data;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.response.SearchResponse;

import retrofit2.Call;

public interface RepoRepository {
    Call<SearchResponse> searchUsers(String searchTerm);
}
