package com.example.carilaundry

data class OrderModel(
    val serviceName: String,  // Contoh: Cuci & Lipat
    val weight: String,       // Contoh: 5 kg
    val totalPrice: String,   // Contoh: Rp 40,000
    val status: String,       // Contoh: Proses Pengerjaan
    val estimation: String    // Contoh: Besok, 14:00
)