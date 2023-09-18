package com.dmendanyo.myplaces.data

import com.dmendanyo.data.datasource.MyPlacesRemoteDataSource
import com.dmendanyo.domain.models.CategoryModel
import com.dmendanyo.myplaces.di.ApiKey
import javax.inject.Inject

class MyPlacesRemoteDataSourceImpl @Inject constructor(
    private val service: RemoteService,
    @ApiKey private val apiKey: String,
) : MyPlacesRemoteDataSource {

    override suspend fun getCategories(filters: List<String>): Result<List<CategoryModel>> =
        tryCall {
            service.getCategories(
                filters,
                "circle:-87.770231,41.878968,5000",
                apiKey
            )
        }
}

suspend fun <T> tryCall(call: suspend () -> T): Result<T> =
    try {
        val result = call.invoke()
        Result.success(result)
    } catch (exception: Exception) {
        Result.failure(exception)
    }