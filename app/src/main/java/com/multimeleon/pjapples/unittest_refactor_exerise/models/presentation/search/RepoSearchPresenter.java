package com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.RepoRepository;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.response.SearchResponse;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoSearchPresenter extends BasePresenter<RepoSearchContract.View> implements RepoSearchContract.Presenter {
    private RepoRepository repoRepository;

    RepoSearchPresenter(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public void searchGitHubRepo(String query) {
        checkViewAttached();
        getView().showLoading();

        repoRepository.searchUsers(query).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call,
                                   Response<SearchResponse> response) {
                handleResponse(response);
            }

            @Override
            public void onFailure(Call<SearchResponse> call,
                                  Throwable t) {
                Log.e("", "", t);
                getView().handleError("E103 - System error");
            }
        });
    }

    private void handleResponse(@NonNull Response<SearchResponse> response) {
        if (response.isSuccessful()) {
            SearchResponse searchResponse = response.body();
            if (searchResponse != null) {
                getView().handleSearchResults(searchResponse.getSearchResults());
            } else {
                getView().handleError("E102 - System error");
            }
        } else {
            getView().handleError("E101 - System error");
        }
    }
}
