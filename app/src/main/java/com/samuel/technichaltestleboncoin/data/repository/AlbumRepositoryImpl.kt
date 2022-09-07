package com.samuel.technichaltestleboncoin.data.repository

import com.samuel.technichaltestleboncoin.common.Constant
import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.data.local.AlbumDao
import com.samuel.technichaltestleboncoin.data.remote.AlbumApi
import com.samuel.technichaltestleboncoin.data.remote.dto.toAlbumEntity
import com.samuel.technichaltestleboncoin.domain.model.Album
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val api: AlbumApi,
    private val dao: AlbumDao
) : AlbumRepository{

    override fun getAlbums(): Flow<Resource<List<Album>>> = flow {
        emit(Resource.Loading())
        val albums = dao.getAlbums().map { it.toAlbum() }
        emit(Resource.Loading(data = albums))
        try {
            val remoteAlbums = api.getAlbums()
            dao.deleteAlbum(remoteAlbums.map { it.albumId })
            dao.insertAlbum(remoteAlbums.map { it.toAlbumEntity() })
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured", data = albums))
        } catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection", data = albums))
        }

        val albumsRefreshed = dao.getAlbums().map { it.toAlbum() }
        emit(Resource.Success(albumsRefreshed))
    }
}