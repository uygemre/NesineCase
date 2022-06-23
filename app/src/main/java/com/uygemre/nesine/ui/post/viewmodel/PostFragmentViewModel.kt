package com.uygemre.nesine.ui.post.viewmodel

import androidx.lifecycle.Transformations
import com.uygemre.nesine.base.BaseViewModel
import com.uygemre.nesine.extensions.toLiveData
import com.uygemre.nesine.networking.DataFetchResult
import com.uygemre.nesine.recyclerview.DisplayItem
import com.uygemre.nesine.response.GetPostsResponse
import com.uygemre.nesine.ui.post.repository.PostFragmentRepository
import com.uygemre.nesine.viewholder.post.PostDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class PostFragmentViewModel @Inject constructor(
    private val repository: PostFragmentRepository
) : BaseViewModel() {

    val itemPublishSubject = PublishSubject.create<List<DisplayItem>>()

    val getPostsLiveData =
        Transformations.map(repository.getPostsPublishSubject.toLiveData(disposables))
        { response ->
            when (response) {
                is DataFetchResult.Success -> {
                    consumeData(response.data)
                }
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {
                }
            }

            response
        }

    private fun consumeData(data: List<GetPostsResponse>) {
        val list = mutableListOf<DisplayItem>()

        data.map { getPostsResponse ->
            list.add(
                PostDTO(
                    title = getPostsResponse.title,
                    id = getPostsResponse.id,
                    userId = getPostsResponse.userId,
                    body = getPostsResponse.body
                )
            )
        }

        itemPublishSubject.onNext(list)
    }

    fun getPosts() = repository.getPosts()
}