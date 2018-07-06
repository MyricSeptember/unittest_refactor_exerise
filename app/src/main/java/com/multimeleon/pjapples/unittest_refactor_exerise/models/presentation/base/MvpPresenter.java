package com.multimeleon.pjapples.unittest_refactor_exerise.models.presentation.base;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
