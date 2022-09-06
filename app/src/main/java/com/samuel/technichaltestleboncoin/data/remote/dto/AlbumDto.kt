package com.samuel.technichaltestleboncoin.data.remote.dto

import com.samuel.technichaltestleboncoin.data.local.AlbumEntity

data class AlbumDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun AlbumDto.toAlbumEntity(): AlbumEntity{
    return AlbumEntity(
        albumId = albumId,
        id = id,
        thumbnailUrl = thumbnailUrl,
        title = title
    )
}


