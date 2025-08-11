package com.example.wallpaper.Api


import com.example.wallpaper.model.PexelsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("curated")
    suspend fun getWallpapers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20,
        @Header("Authorization") apiKey: String
    ): PexelsResponse

    @GET("search")
    suspend fun searchWallpapers(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20,
        @Header("Authorization") apiKey: String
    ): PexelsResponse
}
