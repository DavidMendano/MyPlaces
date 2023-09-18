package com.dmendanyo.domain.usecases

import com.dmendanyo.domain.models.CategoryModel
import com.dmendanyo.domain.repositories.MyPlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: MyPlacesRepository
) {

    suspend fun invoke(): Flow<List<CategoryModel>> = repository.getCategories()
}
