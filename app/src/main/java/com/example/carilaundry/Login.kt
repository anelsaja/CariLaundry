package com.example.carilaundry

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Cari tombol Google (CardView tadi)
        val btnGoogle = findViewById<CardView>(R.id.btnGoogleLogin)

        btnGoogle.setOnClickListener {
            // Logic Login Dummy (langsung sukses)
            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke MainActivity (Halaman Home)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup halaman login agar tidak bisa back
        }
    }
}