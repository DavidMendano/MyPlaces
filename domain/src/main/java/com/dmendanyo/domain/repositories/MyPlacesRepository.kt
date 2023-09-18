package com.dmendanyo.domain.repositories

import com.dmendanyo.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface MyPlacesRepository {

    suspend fun getCategories(): Flow<List<CategoryModel>>
}
