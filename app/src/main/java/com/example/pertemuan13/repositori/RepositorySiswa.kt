package com.example.pertemuan13.repositori

import com.example.pertemuan13.model.Siswa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

interface RepositorySiswa {
    suspend fun getAllSiswa(): List<Siswa>
    suspend fun insertSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun getSiswaById(idSiswa: String): Siswa
}

class NetworkRepositorySiswa(
    private val firestore: FirebaseFirestore
) : RepositorySiswa {

    // Ambil semua data siswa (Read)
    override suspend fun getAllSiswa(): List<Siswa> {
        return try {
            firestore.collection("Siswa")
                .orderBy("nama", Query.Direction.ASCENDING) // Urutkan berdasarkan nama
                .get()
                .await()
                .toObjects(Siswa::class.java) // Otomatis mapping dari JSON Firestore ke object Siswa
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun insertSiswa(siswa: Siswa) {
        try {
            val documentReference = firestore.collection("Siswa").document()
            val siswaWithId = siswa.copy(id = documentReference.id)
            documentReference.set(siswaWithId).await()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun updateSiswa(siswa: Siswa) {
        try {
            firestore.collection("Siswa")
                .document(siswa.id)
                .set(siswa)
                .await()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun deleteSiswa(siswa: Siswa) {
        try {
            firestore.collection("Siswa")
                .document(siswa.id)
                .delete()
                .await()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getSiswaById(idSiswa: String): Siswa {
        return try {
            val documentSnapshot = firestore.collection("Siswa")
                .document(idSiswa)
                .get()
                .await()

            documentSnapshot.toObject(Siswa::class.java)!!
        } catch (e: Exception) {
            Siswa()
        }
    }
}