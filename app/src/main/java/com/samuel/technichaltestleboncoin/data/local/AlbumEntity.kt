package com.samuel.technichaltestleboncoin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samuel.technichaltestleboncoin.domain.model.Album

@Entity
data class AlbumEntity (
    val albumId: Int,
    val thumbnailUrl: String,
    val title: String,
    @PrimaryKey val id: Int,
){
    fun toAlbum(): Album{
        return Album(
            albumId = albumId,
            thumbnailUrl = thumbnailUrl,
            title = title,
            id = id
        )
    }
}