package com.samuel.technichaltestleboncoin.presentation.album_list

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuel.technichaltestleboncoin.common.Resource
import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
): ViewModel(){

    private val _state = MutableLiveData<AlbumListState>()
    var state: LiveData<AlbumListState> = _state

    init {
        getAlbums()
    }

    private fun getAlbums(){
            getAlbumsUseCase().onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = AlbumListState(albums = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = AlbumListState(error = result.message ?: "Unexpected error occured")
                    }
                    is Resource.Loading -> {
                        _state.value = AlbumListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}