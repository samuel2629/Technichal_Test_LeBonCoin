package com.samuel.technichaltestleboncoin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(albums: List<AlbumEntity>)

    @Query("DELETE FROM albumentity")
    suspend fun deleteAlbums()

    @Query("SELECT * FROM albumentity")
    suspend fun getAlbums() : List<AlbumEntity>
}