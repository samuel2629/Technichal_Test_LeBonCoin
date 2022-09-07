package com.samuel.technichaltestleboncoin.presentation.album_list

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.technichaltestleboncoin.AlbumApplication
import com.samuel.technichaltestleboncoin.R
import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
): ViewModel(){

    private val _state = MutableLiveData<AlbumListState>()
    var state: LiveData<AlbumListState> = _state

    init {
        getAlbums()
    }

    fun getAlbums(){
            getAlbumsUseCase().onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = AlbumListState(albums = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = AlbumListState(isError = true, error = result.message)
                    }
                    is Resource.Loading -> {
                        _state.value = AlbumListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}