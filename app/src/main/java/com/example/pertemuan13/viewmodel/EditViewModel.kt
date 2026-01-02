package com.example.pertemuan13.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan13.repositori.RepositorySiswa
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa
) : ViewModel() {

    var siswaUiState by mutableStateOf(UIStateMhs())
        private set

    private val itemId: String = checkNotNull(savedStateHandle["idSiswa"])

    init {
        viewModelScope.launch {
            siswaUiState = repositorySiswa.getSiswaById(itemId).toUiStateMhs(true)
        }
    }

    fun updateUiState(detailMhs: DetailMhs) {
        siswaUiState = UIStateMhs(detailMhs = detailMhs, isEntryValid = validasiInput(detailMhs))
    }

    private fun validasiInput(uiState: DetailMhs = siswaUiState.detailMhs): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateSiswa() {
        viewModelScope.launch {
            try {
                if (validasiInput()) {
                    repositorySiswa.updateSiswa(siswaUiState.detailMhs.toSiswa())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}