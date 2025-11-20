package com.example.carilaundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoriteAdapter(private val listFav: List<LaundryModel>) :
    RecyclerView.Adapter<FavoriteAdapter.FavViewHolder>() {

    class FavViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaFav)
        val tvAlamat: TextView = view.findViewById(R.id.tvAlamatFav)
        val tvPhone: TextView = view.findViewById(R.id.tvPhoneFav)
        val imgLaundry: ImageView = view.findViewById(R.id.imgLaundryFav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite, parent, false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val item = listFav[position]
        holder.tvNama.text = item.nama
        holder.tvAlamat.text = item.alamat
        holder.tvPhone.text = item.telepon // Pastikan di LaundryModel ada field telepon
        holder.imgLaundry.setImageResource(item.gambarId)
    }

    override fun getItemCount(): Int = listFav.size
}