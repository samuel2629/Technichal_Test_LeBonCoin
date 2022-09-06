package com.samuel.technichaltestleboncoin.data.repository

import com.samuel.technichaltestleboncoin.data.remote.AlbumApi
import com.samuel.technichaltestleboncoin.data.remote.dto.AlbumDto
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val api: AlbumApi
) : AlbumRepository{

    override suspend fun getAlbums(): List<AlbumDto> {
        return api.getAlbums()
    }
}