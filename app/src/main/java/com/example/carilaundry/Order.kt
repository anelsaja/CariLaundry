package com.example.carilaundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orderList: List<OrderModel>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvService: TextView = view.findViewById(R.id.tvService)
        val tvWeight: TextView = view.findViewById(R.id.tvWeight)
        val tvTotal: TextView = view.findViewById(R.id.tvTotal)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
        val tvEstimasi: TextView = view.findViewById(R.id.tvEstimasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = orderList[position]
        holder.tvService.text = item.serviceName
        holder.tvWeight.text = item.weight
        holder.tvTotal.text = item.totalPrice
        holder.tvStatus.text = item.status
        holder.tvEstimasi.text = "Estimasi: ${item.estimation}"
    }

    override fun getItemCount(): Int = orderList.size
}