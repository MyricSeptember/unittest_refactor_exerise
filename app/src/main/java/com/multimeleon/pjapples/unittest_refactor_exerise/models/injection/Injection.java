package com.multimeleon.pjapples.unittest_refactor_exerise.models.injection;

import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.RepoRepository;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.RepoRepositoryImpl;
import com.multimeleon.pjapples.unittest_refactor_exerise.models.data.remote.GithubRepoRestService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    private static GithubRepoRestService repoRestService;


    public static RepoRepository providesRepoRepo() {
        return new RepoRepositoryImpl(providesGithubRepoRestService());
    }

    static GithubRepoRestService providesGithubRepoRestService() {
        if (repoRestService == null) {
            repoRestService =  providesRetrofit().create(GithubRepoRestService.class);
        }
        return repoRestService;
    }
    static Retrofit providesRetrofit(){

        Retrofit retrofit = null;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
