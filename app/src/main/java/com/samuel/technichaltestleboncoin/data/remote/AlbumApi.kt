package com.samuel.technichaltestleboncoin.data.remote

import com.samuel.technichaltestleboncoin.data.remote.dto.AlbumDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface AlbumApi {

    @GET("/img/shared/technical-test.json")
    suspend fun getAlbums(): List<AlbumDto>
}