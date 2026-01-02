package com.example.pertemuan13.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan13.model.Siswa
import com.example.pertemuan13.repositori.RepositorySiswa
import kotlinx.coroutines.launch

class EntryViewModel(private val mhs: RepositorySiswa) : ViewModel() {
    var uiStateMhs by mutableStateOf(UIStateMhs())
        private set

    fun updateUiState(detailMhs: DetailMhs) {
        uiStateMhs = UIStateMhs(detailMhs = detailMhs, isEntryValid = validasiInput(detailMhs))
    }

    private fun validasiInput(uiState: DetailMhs = uiStateMhs.detailMhs): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun saveData() {
        viewModelScope.launch {
            if (validasiInput()) {
                mhs.insertSiswa(uiStateMhs.detailMhs.toSiswa())
            }
        }
    }
}

data class UIStateMhs(
    val detailMhs: DetailMhs = DetailMhs(),
    val isEntryValid: Boolean = false
)

data class DetailMhs(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

fun DetailMhs.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toDetailMhs(): DetailMhs = DetailMhs(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateMhs(isEntryValid: Boolean = false): UIStateMhs = UIStateMhs(
    detailMhs = this.toDetailMhs(),
    isEntryValid = isEntryValid
)