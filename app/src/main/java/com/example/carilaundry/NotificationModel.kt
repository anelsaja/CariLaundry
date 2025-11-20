package com.example.carilaundry

data class NotificationModel(
    val title: String,
    val message: String,
    val time: String,
    val type: String // "info", "success", "process" (untuk membedakan warna ikon nanti jika mau)
)