package com.samuel.technichaltestleboncoin.domain.repository

import com.samuel.technichaltestleboncoin.data.remote.dto.AlbumDto

interface AlbumRepository {

    suspend fun getAlbums(): List<AlbumDto>
}