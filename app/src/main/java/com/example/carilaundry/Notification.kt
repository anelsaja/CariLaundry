package com.example.carilaundry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationAdapter(private val notifList: List<NotificationModel>) :
    RecyclerView.Adapter<NotificationAdapter.NotifViewHolder>() {

    class NotifViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvNotifTitle)
        val tvMessage: TextView = view.findViewById(R.id.tvNotifMessage)
        val tvTime: TextView = view.findViewById(R.id.tvNotifTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return NotifViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotifViewHolder, position: Int) {
        val item = notifList[position]
        holder.tvTitle.text = item.title
        holder.tvMessage.text = item.message
        holder.tvTime.text = item.time
    }

    override fun getItemCount(): Int = notifList.size
}