package com.samuel.technichaltestleboncoin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AlbumEntity::class],
    version = 1
)
abstract class AlbumDatabase: RoomDatabase() {

    abstract val dao: AlbumDao
}