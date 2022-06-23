package com.uygemre.nesine.service

import com.uygemre.nesine.response.GetPostsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(value = "posts")
    fun getPosts(): Single<List<GetPostsResponse>>
}