package com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.search;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.SearchResult;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.base.MvpPresenter;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.base.MvpView;

import java.util.List;

public interface RepoSearchContract {
    interface View extends MvpView {
        void handleError(String message);
        void handleSearchResults(List<SearchResult> searchResults);


        void showLoading();

        void hideLoading();
    }

    interface Presenter extends MvpPresenter<View> {
        void searchGitHubRepo(String query);
    }

}
