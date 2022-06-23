package com.uygemre.nesine.ui.post.repository

import com.uygemre.nesine.extensions.*
import com.uygemre.nesine.networking.DataFetchResult
import com.uygemre.nesine.networking.Scheduler
import com.uygemre.nesine.response.GetPostsResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

class PostFragmentRepository @Inject constructor(
    private val remote: PostFragmentRemoteData,
    private val scheduler: Scheduler
) : PostFragmentContract.Repository {

    override val getPostsPublishSubject = PublishSubject.create<DataFetchResult<List<GetPostsResponse>>>()
    override val disposable: CompositeDisposable = CompositeDisposable()

    override fun getPosts() {
        getPostsPublishSubject.loading(isLoading = true)
        remote.getPosts()
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                { response ->
                    getPostsPublishSubject.success(response)
                },
                { error ->
                    handleError(getPostsPublishSubject, error)
                }
            ).addTo(disposable)
    }

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
        Timber.e(error)
    }
}