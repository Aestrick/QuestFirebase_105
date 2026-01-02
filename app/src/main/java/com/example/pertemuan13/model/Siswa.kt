package com.example.pertemuan13.model

data class Siswa(
    val id: String,
    val nama: String,
    val alamat: String,
    val telpon: String
) {
    constructor() : this("", "", "", "")
}