package com.samuel.technichaltestleboncoin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.viewModelFactory
import com.samuel.technichaltestleboncoin.R
import com.samuel.technichaltestleboncoin.domain.repository.AlbumRepository
import com.samuel.technichaltestleboncoin.domain.use_case.get_albums.GetAlbumsUseCase
import com.samuel.technichaltestleboncoin.presentation.album_list.AlbumListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}