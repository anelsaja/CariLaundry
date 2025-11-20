package com.example.carilaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvLaundry: RecyclerView
    private val listLaundry = ArrayList<LaundryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLaundry = findViewById(R.id.rvLaundry)
        rvLaundry.setHasFixedSize(true)

        // Mengatur Layout menjadi GRID 2 Kolom
        rvLaundry.layoutManager = GridLayoutManager(this, 2)

        // Isi Data Dummy
        listLaundry.add(LaundryModel("Laundry Wertwer", "Jalan Senopati No 3", "+62 813-2707-4781", "135 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Laundry Bersih", "Jalan Mawar No 10", "+62 812-3333-4444", "200 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Cuci Kilat", "Jalan Melati No 5", "+62 811-5555-6666", "500 m", R.drawable.cari))
        listLaundry.add(LaundryModel("Mama Laundry", "Jalan Anggrek No 12", "+62 815-7777-8888", "1.2 km", R.drawable.cari))

        // Pasang Adapter
        val adapter = LaundryAdapter(listLaundry)
        rvLaundry.adapter = adapter
    }
}