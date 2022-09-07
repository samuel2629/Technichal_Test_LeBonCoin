package com.samuel.technichaltestleboncoin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AlbumEntity::class],
    version = 3
)
abstract class AlbumDatabase: RoomDatabase() {

    abstract val dao: AlbumDao
}