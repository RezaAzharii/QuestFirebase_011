package com.example.pertemuafirebasedb.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuafirebasedb.MahasiswaApp
import com.example.pertemuafirebasedb.ui.home.viewmodel.DetailViewModel
import com.example.pertemuafirebasedb.ui.home.viewmodel.HomeViewModel
import com.example.pertemuafirebasedb.ui.home.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                mahasiswaApp().container.repositoryMhs
            )
        }
        initializer {
            InsertViewModel(
                mahasiswaApp().container.repositoryMhs
            )
        }

    }
}

fun CreationExtras.mahasiswaApp(): MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)