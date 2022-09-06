package com.samuel.technichaltestleboncoin.domain.repository

import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    fun getAlbums(): Flow<Resource<List<Album>>>
}