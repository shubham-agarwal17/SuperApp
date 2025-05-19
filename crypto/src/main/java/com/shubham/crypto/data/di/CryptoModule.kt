package com.shubham.crypto.data.di

import android.content.Context
import androidx.room.Room
import com.shubham.crypto.data.local.dao.CryptoListDao
import com.shubham.crypto.data.local.db.CryptoListDatabase
import com.shubham.crypto.data.remote.api.CryptoApi
import com.shubham.crypto.data.repository.CryptoRepositoryImpl
import com.shubham.crypto.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CryptoModule {

    @Provides
    @Singleton
    fun provideWealthApi() : CryptoApi {
        return Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CryptoListDatabase {
        return Room.databaseBuilder(
            context,
            CryptoListDatabase::class.java,
            "crypto_database"
        ).build()
    }

    @Provides
    fun provideCryptoListDao(database: CryptoListDatabase): CryptoListDao = database.cryptoListDao()

    @Provides
    fun provideWealthRepository(api: CryptoApi, cryptoListDao: CryptoListDao) : CryptoRepository {
        return CryptoRepositoryImpl(api, cryptoListDao)
    }
}