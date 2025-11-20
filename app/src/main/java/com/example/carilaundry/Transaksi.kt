package com.example.carilaundry

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderHistoryActivity : AppCompatActivity() {

    private lateinit var rvHistory: RecyclerView
    private val orderList = ArrayList<OrderModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        rvHistory = findViewById(R.id.rvOrderHistory)
        rvHistory.layoutManager = LinearLayoutManager(this)

        // Tombol Back
        findViewById<ImageView>(R.id.btnBackHistory).setOnClickListener {
            finish()
        }

        populateData()

        val adapter = OrderAdapter(orderList)
        rvHistory.adapter = adapter
    }

    private fun populateData() {
        // Sesuai Screenshot
        orderList.add(
            OrderModel(
                serviceName = "Cuci & Lipat",
                weight = "5 kg",
                totalPrice = "Rp 40,000",
                status = "Proses Pengerjaan",
                estimation = "Besok, 14:00"
            )
        )

        // Data Tambahan Dummy
        orderList.add(
            OrderModel(
                serviceName = "Cuci Kering (Dry Clean)",
                weight = "2 Pcs",
                totalPrice = "Rp 75,000",
                status = "Menunggu Kurir",
                estimation = "Hari ini, 17:00"
            )
        )
    }
}