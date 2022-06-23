package com.uygemre.nesine.ui.post.repository

import com.uygemre.nesine.service.ApiService
import javax.inject.Inject

class PostFragmentRemoteData @Inject constructor(
    private val service: ApiService
) : PostFragmentContract.Remote {

    override fun getPosts() = service.getPosts()

}