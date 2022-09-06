package com.samuel.technichaltestleboncoin.domain.use_case.get_albums

import android.content.res.Resources
import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.data.remote.dto.toAlbum
import com.samuel.technichaltestleboncoin.domain.model.Album
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: AlbumRepository
) {
    operator fun invoke(): Flow<Resource<List<Album>>> = flow {
        try {
            emit(Resource.Loading())
            val albums = repository.getAlbums()
            emit(Resource.Success(albums.map { it.toAlbum() }))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }
}