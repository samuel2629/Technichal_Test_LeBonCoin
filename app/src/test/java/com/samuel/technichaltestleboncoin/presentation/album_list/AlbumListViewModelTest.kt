package com.samuel.technichaltestleboncoin.presentation.album_list

import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
import com.samuel.technichaltestleboncoin.repository.FakeAlbumRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AlbumListViewModelTest{

    private lateinit var viewModel: AlbumListViewModel

    @Before
    fun setup(){
        viewModel = AlbumListViewModel(GetAlbumsUseCase(FakeAlbumRepository()))
    }

    @Test
    fun dd(){
        viewModel.getAlbums()
    }
}