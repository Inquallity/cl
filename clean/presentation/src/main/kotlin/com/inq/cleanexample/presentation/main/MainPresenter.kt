package com.inq.cleanexample.presentation.main

import com.inq.cleanexample.core.domain.MainPresentationBoundary

class MainPresenter constructor(
    private val mainView: MainActivity,
    private val mainPresentationBoundary: MainPresentationBoundary
) {

    fun performAcquireUserToken() {
        mainView.showLoading()
        mainPresentationBoundary.acquireUserToken(
            mainView::showToken
        ) { /* show error on screen */ }
    }
}