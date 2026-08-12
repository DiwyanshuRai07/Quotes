package com.quotes.di

import com.quotes.data.remote.APIService
import com.quotes.data.repositoryImpl.QuoteRepositoryImpl
import com.quotes.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun getQuotesRepository(
        apiService: APIService
    ): QuoteRepository = QuoteRepositoryImpl(apiService = apiService)
}