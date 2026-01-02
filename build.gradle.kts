plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // Perbaikan: Pakai titik (.) bukan minus (-)
    alias(libs.plugins.google.services) apply false
}