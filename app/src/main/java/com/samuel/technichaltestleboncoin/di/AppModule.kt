package com.samuel.technichaltestleboncoin.di

import com.samuel.technichaltestleboncoin.common.Constant
import com.samuel.technichaltestleboncoin.data.remote.AlbumApi
import com.samuel.technichaltestleboncoin.data.repository.AlbumRepositoryImpl
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAlbumApi() : AlbumApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAlbumRepository(api: AlbumApi): AlbumRepository{
        return AlbumRepositoryImpl(api)
    }
}