package com.example.carilaundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaundryAdapter(private val dataList: List<LaundryModel>) :
    RecyclerView.Adapter<LaundryAdapter.LaundryViewHolder>() {

    class LaundryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNama)
        val tvAlamat: TextView = view.findViewById(R.id.tvAlamat)
        val tvTelepon: TextView = view.findViewById(R.id.tvTelepon)
        val tvJarak: TextView = view.findViewById(R.id.tvJarak)
        val imgLaundry: ImageView = view.findViewById(R.id.imgLaundry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_laundry, parent, false)
        return LaundryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaundryViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvNama.text = item.nama
        holder.tvAlamat.text = item.alamat
        holder.tvTelepon.text = item.telepon
        holder.tvJarak.text = item.jarak
        holder.imgLaundry.setImageResource(item.gambarId)
    }

    override fun getItemCount(): Int = dataList.size
}