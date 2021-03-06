package com.yangPentingLulus.DCEMS.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yangPentingLulus.DCEMS.MyData
import com.yangPentingLulus.DCEMS.R
import com.yangPentingLulus.DCEMS.ui.dashboard.DashboardFragment

class CardViewMyDataAdapter(private val listMyDatas: ArrayList<MyData>) :
    RecyclerView.Adapter<CardViewMyDataAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return CardViewViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val myData = listMyDatas[position]
        holder.tvName.text = myData.name
        holder.tvTemperature.text = myData.temperature
        holder.tvHumidity.text = myData.humidity
        holder.tvStatus.text = myData.status
    }
    override fun getItemCount(): Int {
        return listMyDatas.size
    }
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvTemperature: TextView = itemView.findViewById(R.id.tv_item_temperature)
        var tvHumidity: TextView = itemView.findViewById(R.id.tv_item_humidity)
        var tvStatus: TextView = itemView.findViewById(R.id.tv_item_status)

    }
}
