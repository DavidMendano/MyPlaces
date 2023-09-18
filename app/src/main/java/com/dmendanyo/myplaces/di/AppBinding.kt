package com.dmendanyo.myplaces.di

import com.dmendanyo.data.MyPlacesRepositoryImpl
import com.dmendanyo.data.datasource.MyPlacesRemoteDataSource
import com.dmendanyo.domain.repositories.MyPlacesRepository
import com.dmendanyo.myplaces.data.MyPlacesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBinding {

    @Binds
    abstract fun bindMyPlacesRepository(
        repositoryImpl: MyPlacesRepositoryImpl
    ): MyPlacesRepository

    @Binds
    abstract fun bindMyPlacesRemoteDataSource(
        repositoryImpl: MyPlacesRemoteDataSourceImpl
    ): MyPlacesRemoteDataSource
}
