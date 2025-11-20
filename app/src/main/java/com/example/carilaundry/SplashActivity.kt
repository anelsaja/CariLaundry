package com.example.carilaundry

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menyembunyikan ActionBar supaya full screen (Opsional)
        supportActionBar?.hide()

        // Timer 3 Detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Setelah 3 detik, pindah ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Agar user tidak bisa kembali ke splash screen
        }, 3000)
    }
}