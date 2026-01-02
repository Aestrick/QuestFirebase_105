package com.example.pertemuan13.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan13.model.Siswa
import com.example.pertemuan13.repositori.RepositorySiswa
import kotlinx.coroutines.launch

sealed interface DetailUiState {
    data class Success(val siswa: Siswa) : DetailUiState
    object Error : DetailUiState
    object Loading : DetailUiState
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa
) : ViewModel() {

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _idSiswa: String = checkNotNull(savedStateHandle["idSiswa"])

    init {
        getSiswaById()
    }

    fun getSiswaById() {
        viewModelScope.launch {
            detailUiState = DetailUiState.Loading
            detailUiState = try {
                val siswa = repositorySiswa.getSiswaById(_idSiswa)
                DetailUiState.Success(siswa)
            } catch (e: Exception) {
                DetailUiState.Error
            }
        }
    }
}