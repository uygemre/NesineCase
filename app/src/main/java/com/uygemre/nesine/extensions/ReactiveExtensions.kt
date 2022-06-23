package com.uygemre.nesine.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import com.uygemre.nesine.networking.Scheduler
import io.reactivex.Single

fun <T> Single<T>.performOnBackOutOnMain(scheduler: Scheduler): Single<T> {
    return this.subscribeOn(scheduler.io())
        .observeOn(scheduler.mainThread())
}

fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}