package com.samuel.technichaltestleboncoin.di

import android.app.Application
import androidx.room.Room
import com.samuel.technichaltestleboncoin.common.Constant
import com.samuel.technichaltestleboncoin.data.local.AlbumDatabase
import com.samuel.technichaltestleboncoin.data.remote.AlbumApi
import com.samuel.technichaltestleboncoin.data.repository.AlbumRepositoryImpl
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
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
    fun provideAlbumDatabase(application: Application) : AlbumDatabase{
        return Room.databaseBuilder(application, AlbumDatabase::class.java, "album_db").build()
    }

    @Provides
    @Singleton
    fun provideAlbumRepository(api: AlbumApi, db: AlbumDatabase): AlbumRepository{
        return AlbumRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideAlbums(repository: AlbumRepository): GetAlbumsUseCase{
        return GetAlbumsUseCase(repository)
    }
}