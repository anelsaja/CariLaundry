package com.example.carilaundry

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationActivity : AppCompatActivity() {

    private lateinit var rvNotif: RecyclerView
    private val listNotif = ArrayList<NotificationModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        rvNotif = findViewById(R.id.rvNotification)
        rvNotif.layoutManager = LinearLayoutManager(this)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btnBackNotif)
        btnBack.setOnClickListener {
            finish()
        }

        populateData()

        val adapter = NotificationAdapter(listNotif)
        rvNotif.adapter = adapter
    }

    private fun populateData() {
        listNotif.add(NotificationModel("Pesanan Selesai", "Laundry Anda di 'Laundry Bersih' sudah selesai.", "10:30", "success"))
        listNotif.add(NotificationModel("Driver Menjemput", "Driver sedang menuju lokasi Anda.", "09:15", "process"))
        listNotif.add(NotificationModel("Pembayaran Berhasil", "Pembayaran via E-Wallet berhasil dikonfirmasi.", "Kemarin", "info"))
        listNotif.add(NotificationModel("Promo Mingguan", "Dapatkan diskon 20% untuk cuci bed cover!", "Senin", "info"))
    }
}