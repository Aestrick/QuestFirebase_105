# 🔥 QuestFirebase: Aplikasi Data Siswa

Aplikasi Android sederhana untuk mempraktikkan integrasi **Firebase Firestore** dengan **Jetpack Compose**. Aplikasi ini menerapkan arsitektur **MVVM** dan operasi **CRUD** (Create, Read, Update, Delete) secara real-time.

---

## 📸 Dokumentasi Aplikasi

Berikut adalah tampilan antarmuka aplikasi:

| **1. Halaman Utama (Home)** | **2. Tambah Data (Entry)** |
|:---:|:---:|
| <img width="1919" height="1079" alt="Screenshot 2026-01-08 174954" src="https://github.com/user-attachments/assets/f4a80b95-9844-4d79-a8df-e5ba52ee9b18" /> | <img width="553" height="960" alt="Screenshot 2026-01-02 155358" src="https://github.com/user-attachments/assets/eece5225-eb80-4402-8f85-d3ae3e09320c" /> |
| *Menampilkan daftar siswa dari Firestore* | *Form input data siswa baru* |

| **3. Detail Siswa** | **4. Edit Data** |
|:---:|:---:|
| <img width="561" height="967" alt="Screenshot 2026-01-02 155421" src="https://github.com/user-attachments/assets/23edd739-6faa-4190-9d33-010d5bbc64ab" /> | <img width="556" height="971" alt="Screenshot 2026-01-02 155534" src="https://github.com/user-attachments/assets/877b1d1d-ca80-450a-bf23-34bb74d9a5b8" /> |
| *Menampilkan detail lengkap siswa* | *Form update data siswa* |

*(Catatan: File gambar disimpan dalam folder `screenshots` di root project)*

---

## 🚀 Fitur Utama

* **Cloud Firestore:** Penyimpanan data terpusat dan *real-time* di server Google.
* **CRUD Operations:**
    * **Create:** Menambahkan data siswa baru.
    * **Read:** Menampilkan daftar siswa dan detail spesifik.
    * **Update:** Mengubah data siswa yang sudah ada.
    * **Delete:** Menghapus data siswa dari database.
* **MVVM Architecture:** Pemisahan kode yang rapi antara UI, ViewModel, dan Repository.
* **Error Handling:** Menangani status *Loading*, *Success*, dan *Error* saat mengambil data.
* **Refreshable:** Fitur *pull-to-refresh* (via tombol refresh) untuk memuat ulang data.

---

## 🛠️ Teknologi & Library

* **Bahasa:** Kotlin
* **Framework UI:** Jetpack Compose (Material3)
* **Backend:** Firebase Firestore (NoSQL Database)
* **Navigasi:** Jetpack Navigation Compose
* **Asynchronous:** Kotlin Coroutines & Play Services Tasks
* **Dependency Injection:** Manual Injection (`AppContainer`)

---

## ⚙️ Cara Menjalankan Project

1.  **Clone Repository:**
    ```bash
    git clone [https://github.com/](https://github.com/)Aestrick/QuestFirebase_105.git
    ```
2.  **Konfigurasi Firebase:**
    * Buat project di Firebase Console.
    * Download file `google-services.json`.
    * Letakkan file tersebut di dalam folder `app/`.
3.  **Build & Run:**
    * Buka project di Android Studio.
    * Sync Gradle.
    * Jalankan pada Emulator atau Device fisik (Minimal Android 8.0 / API 26).

---

## 👤 Identitas Pengembang

* **Nama:** Nashrul Fikri
* **NIM:** 20230140105
* **Kelas:** C
* **Mata Kuliah:** Pengembangan Aplikasi Mobile (Activity 11 - Firebase)
