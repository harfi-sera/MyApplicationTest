package com.ibid.myapplication.module.service

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/users")
    fun getItem(): Call<ItemList>
}