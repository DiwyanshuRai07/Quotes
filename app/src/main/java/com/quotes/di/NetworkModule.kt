package com.quotes.di

import com.quotes.data.remote.APIService
import com.quotes.network.BASE_URL
import com.quotes.network.BASE_URL_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseURL(): String = BASE_URL

    @Singleton
    @Provides
    @Named("BASE_URL_2")
    fun getBaseURL2(): String = BASE_URL_2

    @Singleton
    @Provides
    fun getRetrofitClient(@Named("base_url") baseUrl: String): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).build()


    @Singleton
    @Provides
    fun getAPIClient(retrofit: Retrofit) : APIService =  retrofit.create(APIService::class.java)

}