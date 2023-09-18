package com.dmendanyo.data.datasource

import com.dmendanyo.domain.models.CategoryModel

interface MyPlacesRemoteDataSource {

    suspend fun getCategories(filters: List<String>): Result<List<CategoryModel>>
}