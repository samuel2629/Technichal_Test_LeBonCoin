package com.samuel.technichaltestleboncoin.presentation.album_list

import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
import com.samuel.technichaltestleboncoin.repository.FakeAlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class AlbumListViewModelTest{

    private lateinit var viewModel: AlbumListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup(){
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = AlbumListViewModel(GetAlbumsUseCase(FakeAlbumRepository()))
    }

    @Test
    fun `retrieve albums with success`(){
        return viewModel.getAlbums()
    }
}