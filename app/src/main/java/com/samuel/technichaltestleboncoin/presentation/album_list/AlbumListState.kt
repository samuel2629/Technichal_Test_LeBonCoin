package com.samuel.technichaltestleboncoin.presentation.album_list

import com.samuel.technichaltestleboncoin.domain.model.Album

data class AlbumListState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val albums: List<Album> = emptyList(),
    val error: String? = null
)
