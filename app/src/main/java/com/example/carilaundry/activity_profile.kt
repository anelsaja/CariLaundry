package com.example.carilaundry

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. Tombol Back
        findViewById<ImageView>(R.id.btnBackProfile).setOnClickListener {
            finish()
        }

        // 2. Tombol Keluar (Logout)
        findViewById<CardView>(R.id.btnLogOut).setOnClickListener {
            // Hapus sesi user (jika pakai database/preference)
            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()

            // Arahkan kembali ke LoginActivity dan hapus semua history activity
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // 3. Setup Bottom Nav (Agar bisa kembali ke Home atau History)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNavProfile)

        val btnHome = bottomNav.getChildAt(0)
        val btnHistory = bottomNav.getChildAt(1)
        // btnProfile adalah childAt(2), tapi kita sedang di halaman ini

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Tambahkan flag agar tidak menumpuk activity
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        btnHistory.setOnClickListener {
            val intent = Intent(this, OrderHistoryActivity::class.java)
            startActivity(intent)
        }
    }
}