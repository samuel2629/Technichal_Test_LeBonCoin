package com.samuel.technichaltestleboncoin.data.remote.dto

import com.samuel.technichaltestleboncoin.domain.model.Album

data class AlbumDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun AlbumDto.toAlbum(): Album{
    return Album(
        albumId = albumId,
        id = id,
        thumbnailUrl = thumbnailUrl,
        title = title
    )
}