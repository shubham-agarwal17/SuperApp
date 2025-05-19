package com.shubham.wealth.data.di

import com.shubham.wealth.data.api.WealthApi
import com.shubham.wealth.data.repository.WealthRepositoryImpl
import com.shubham.wealth.domain.repository.WealthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class WealthModule {

    @Provides
    fun provideWealthRepository(api: WealthApi) : WealthRepository {
        return WealthRepositoryImpl(api)
    }

    @Provides
    fun provideWealthApi() : WealthApi {
        return Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WealthApi::class.java)
    }
}