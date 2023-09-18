package com.dmendanyo.data

import com.dmendanyo.data.datasource.MyPlacesRemoteDataSource
import com.dmendanyo.domain.models.CategoryModel
import com.dmendanyo.domain.repositories.MyPlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MyPlacesRepositoryImpl @Inject constructor(
    private val service: MyPlacesRemoteDataSource
) : MyPlacesRepository {

    override suspend fun getCategories(): Flow<List<CategoryModel>> {
        val result = service.getCategories(listOf("commercial.supermarket"))

        return flow {
            emit(
                listOf(
                    CategoryModel(1, "", "Cities"),
                    CategoryModel(2, "", "Restaurants"),
                    CategoryModel(3, "", "Monuments"),
                    CategoryModel(4, "", "Discos"),
                )
            )
        }
    }
}
