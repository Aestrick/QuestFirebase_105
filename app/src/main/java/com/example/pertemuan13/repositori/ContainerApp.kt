package com.example.pertemuan13.repositori

import com.google.firebase.firestore.FirebaseFirestore

interface ContainerApp {
    val repositorySiswa: RepositorySiswa
}

class DefaultContainerApp : ContainerApp {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val repositorySiswa: RepositorySiswa by lazy {
        NetworkRepositorySiswa(firestore)
    }
}