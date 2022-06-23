package com.uygemre.nesine.ui.post.repository

import com.uygemre.nesine.networking.DataFetchResult
import com.uygemre.nesine.response.GetPostsResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

interface PostFragmentContract {

    interface Remote {
        fun getPosts(): Single<List<GetPostsResponse>>
    }

    interface Repository {
        val getPostsPublishSubject: PublishSubject<DataFetchResult<List<GetPostsResponse>>>
        val disposable: CompositeDisposable
        fun getPosts()

        fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }
}