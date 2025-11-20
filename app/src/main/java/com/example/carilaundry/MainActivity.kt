package com.example.carilaundry

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvLaundry: RecyclerView
    private val listLaundry = ArrayList<LaundryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Setup RecyclerView (Daftar Laundry)
        rvLaundry = findViewById(R.id.rvLaundry)
        rvLaundry.setHasFixedSize(true)
        rvLaundry.layoutManager = GridLayoutManager(this, 2)

        // Isi Data Dummy
        populateData()

        // Pasang Adapter
        val adapter = LaundryAdapter(listLaundry)
        rvLaundry.adapter = adapter

        // 2. Setup Tombol Header (Notifikasi)
        setupHeader()

        // 3. Setup Tombol Bawah (Navigasi ke Favorit)
        setupBottomNav()
    }

    private fun setupHeader() {
        // Pastikan di activity_main.xml ikon lonceng sudah diberi ID: android:id="@+id/btnNotif"
        try {
            val btnNotif = findViewById<ImageView>(R.id.iconNotification)
            btnNotif.setOnClickListener {
                val intent = Intent(this, NotificationActivity::class.java)
                startActivity(intent)
            }
        } catch (e: Exception) {
            // Error handling jika lupa kasih ID di XML
            e.printStackTrace()
        }
    }

    private fun setupBottomNav() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNav)

        // Mengambil anak-anak (view) di dalam LinearLayout BottomNav
        // Index 0 = Home, Index 1 = Swap/Favorit, Index 2 = Profile

        val btnHome = bottomNav.getChildAt(0)
        val btnFavorite = bottomNav.getChildAt(1) // Tombol Tengah
        val btnProfile = bottomNav.getChildAt(2)

        btnHome.setOnClickListener {
            Toast.makeText(this, "Anda sudah di Home", Toast.LENGTH_SHORT).show()
        }

        // Klik tombol tengah untuk ke Halaman Favorit
        btnFavorite.setOnClickListener {
            val intent = Intent(this, OrderHistoryActivity::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun populateData() {
        // Bersihkan list dulu agar tidak duplikat saat direload
        listLaundry.clear()

        listLaundry.add(LaundryModel("Laundry Wertwer", "Jalan Senopati No 3", "+62 813-2707-4781", "135 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Laundry Bersih", "Jalan Mawar No 10", "+62 812-3333-4444", "200 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Cuci Kilat", "Jalan Melati No 5", "+62 811-5555-6666", "500 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Mama Laundry", "Jalan Anggrek No 12", "+62 815-7777-8888", "1.2 km", R.drawable.cari))
        listLaundry.add(LaundryModel("Berkah Laundry", "Jalan Kenanga No 1", "+62 819-9999-0000", "1.5 km", R.drawable.cari))
        listLaundry.add(LaundryModel("Laundry Express", "Jalan Kamboja No 8", "+62 818-8888-1111", "2.0 km", R.drawable.cari))
    }
}