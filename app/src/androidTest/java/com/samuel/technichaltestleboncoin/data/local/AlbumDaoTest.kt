package com.samuel.technichaltestleboncoin.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AlbumDaoTest {

    private lateinit var database: AlbumDatabase
    private lateinit var dao: AlbumDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AlbumDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.dao
    }

    @After
    fun teardown(){
        database.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertAlbums() = runTest {
        val album = listOf(AlbumEntity(1, "url", "title", 1))
        dao.insertAlbums(album)

        val retrieveAlbums = dao.getAlbums()

        assertThat(retrieveAlbums).contains(album[0])
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun deleteAlbums() = runTest {
        val album = listOf(AlbumEntity(1, "url", "title", 1))
        dao.insertAlbums(album)
        dao.deleteAlbums()

        assertThat(dao.getAlbums()).doesNotContain(album)
    }
}