package com.nam.recyclerview_basics

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

}