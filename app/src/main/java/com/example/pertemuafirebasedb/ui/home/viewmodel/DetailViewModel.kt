package com.example.pertemuafirebasedb.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuafirebasedb.model.Mahasiswa
import com.example.pertemuafirebasedb.navigation.DestinasiDetail
import com.example.pertemuafirebasedb.repository.RepositoryMhs
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
): ViewModel(){
    var mahasiswaDetailState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    init {
        getMahasiswaByNIM()
    }

     fun getMahasiswaByNIM() {
        viewModelScope.launch {
            mahasiswaDetailState = DetailUiState.Loading
            repositoryMhs.getMhs(_nim)
                .catch { e ->
                    mahasiswaDetailState = DetailUiState.Error(e)
                }
                .collect { data ->
                    mahasiswaDetailState = DetailUiState.Success(data)
                }
        }
    }
}

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: Mahasiswa) : DetailUiState()
    data class Error(val e: Throwable) : DetailUiState()
}