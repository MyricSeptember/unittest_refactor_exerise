package com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.multimeleon.pjapples.unittest_refactor_exerise.R;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.model.SearchResult;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.injection.Injection;

import java.util.List;

public class RepoSearchActivity extends AppCompatActivity implements RepoSearchContract.View {

    private ReposRvAdapter rvAdapter;
    private RepoSearchContract.Presenter repoSearchPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repoSearchPresenter = new RepoSearchPresenter(Injection.providesRepoRepo());
        repoSearchPresenter.attachView(this);
        // progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final EditText etSearchQuery = findViewById(R.id.et_search_query);


        etSearchQuery.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v,
                                          int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    repoSearchPresenter.searchGitHubRepo(etSearchQuery.getText().toString());
                    return true;
                }
                return false;
            }
        });

        RecyclerView rvRepos = findViewById(R.id.rv_repos);
        rvAdapter = new ReposRvAdapter();
        rvRepos.setHasFixedSize(true);
        rvRepos.setAdapter(rvAdapter);
    }

    @Override
    public void handleError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleSearchResults(List<SearchResult> searchResults) {
        rvAdapter.updateResults(searchResults);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        repoSearchPresenter.detachView();
    }
}