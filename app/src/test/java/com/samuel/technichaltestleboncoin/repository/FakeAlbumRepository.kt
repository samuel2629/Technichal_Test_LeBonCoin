package com.samuel.technichaltestleboncoin.repository

import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.domain.model.Album
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAlbumRepository : AlbumRepository{

    private val getAlbumListSuccess = Resource.Success<List<Album>>(emptyList())
    private val observableAlbumListSuccess = flow { emit(getAlbumListSuccess) }

    override fun getAlbums(): Flow<Resource<List<Album>>> {
        return observableAlbumListSuccess
    }
}
