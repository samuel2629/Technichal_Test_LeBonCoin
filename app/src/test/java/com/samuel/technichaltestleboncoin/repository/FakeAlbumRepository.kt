package com.samuel.technichaltestleboncoin.repository

import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.domain.model.Album
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAlbumRepository : AlbumRepository{

    private val getAlbumListSuccess = Resource.Success<List<Album>>(emptyList())
    private val observableAlbumListSuccess = flow { emit(getAlbumListSuccess) }
    private val getAlbumListError = Resource.Error<List<Album>>("Error occured", emptyList())
    private val observableAlbumListError = flow { emit(getAlbumListError) }
    private var shoulReturndNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shoulReturndNetworkError = value
    }

    override fun getAlbums(): Flow<Resource<List<Album>>> {
        return if(shoulReturndNetworkError) observableAlbumListError
        else observableAlbumListSuccess
    }
}
