# 🔥 QuestFirebase: Aplikasi Data Siswa

Aplikasi Android sederhana untuk mempraktikkan integrasi **Firebase Firestore** dengan **Jetpack Compose**. Aplikasi ini menerapkan arsitektur **MVVM** dan operasi **CRUD** (Create, Read, Update, Delete) secara real-time.

---

## 📸 Dokumentasi Aplikasi

Berikut adalah tampilan antarmuka aplikasi:

| **1. Halaman Utama (Home)** | **2. Tambah Data (Entry)** |
|:---:|:---:|
| <img width="1919" height="1079" alt="Screenshot 2026-01-08 174954" src="https://github.com/user-attachments/assets/f4a80b95-9844-4d79-a8df-e5ba52ee9b18" /> | <img width="1919" height="1079" alt="Screenshot 2026-01-08 175035" src="https://github.com/user-attachments/assets/77c55f0a-4901-43ad-81cf-bafce116e2f6" /> |
| *Menampilkan daftar siswa dari Firestore* | *Form input data siswa baru* |

| **3. Detail Siswa** | **4. Edit Data** |
|:---:|:---:|
| <img width="1913" height="1072" alt="Screenshot 2026-01-08 175054" src="https://github.com/user-attachments/assets/6894b86d-77a6-4ac0-b46b-43bab6c0d242" /> | <img width="1919" height="1079" alt="Screenshot 2026-01-08 175200" src="https://github.com/user-attachments/assets/08ebd5e3-5d0f-444e-aa6c-dfbd8cbc17ea" /> |
| *Menampilkan detail lengkap siswa* | *Form update data siswa* |

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
* **Mata Kuliah:** Pengembangan Aplikasi Mobile (Activity 11 dan Activity 12 - Firebase)
