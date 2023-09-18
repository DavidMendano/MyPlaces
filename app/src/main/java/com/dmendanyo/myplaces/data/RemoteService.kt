package com.dmendanyo.myplaces.data

import com.dmendanyo.domain.models.CategoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("places/")
    suspend fun getCategories(
        @Query("categories") categories: List<String>,
        @Query("filter") filter: String,
        @Query("apiKey") apiKey: String,
    ): List<CategoryModel>
}