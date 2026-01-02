package com.example.pertemuan13.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan13.model.Siswa
import com.example.pertemuan13.repositori.RepositorySiswa
import kotlinx.coroutines.launch

sealed interface HomeUiState {
    data class Success(val siswa: List<Siswa>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

class HomeViewModel(private val mhs: RepositorySiswa) : ViewModel() {
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs() {
        viewModelScope.launch {
            mhsUiState = HomeUiState.Loading
            mhsUiState = try {
                HomeUiState.Success(mhs.getAllSiswa())
            } catch (e: Exception) {
                HomeUiState.Error
            }
        }
    }

    fun deleteMhs(siswa: Siswa) {
        viewModelScope.launch {
            try {
                mhs.deleteSiswa(siswa)
                getMhs()
            } catch (e: Exception) {
                mhsUiState = HomeUiState.Error
            }
        }
    }
}