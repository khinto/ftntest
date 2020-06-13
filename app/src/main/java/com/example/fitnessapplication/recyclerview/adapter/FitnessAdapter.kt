package com.example.fitnessapplication.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapplication.R
import com.example.fitnessapplication.room.Ftn_Entity
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class FitnessAdapter(private val ftn: List<Ftn_Entity>) :
    RecyclerView.Adapter<FitnessAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int = ftn.size



    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ftn = ftn[position]

        holder.itemView.days.text = "Day : ${ftn.ftn_day.toString()}"

        holder.itemView.steps.text = "Steps : ${ftn.ftn_step.toString()}"

        holder.itemView.display_sleep.text = "slept hours : ${ftn.ftn_sleep.toString()}"

        holder.itemView.display_weight.text = "Weight : ${ftn.ftn_weight.toString()}"

        holder.itemView.display_km.text = "Km : ${ftn.ftn_km.toString()}"

        holder.itemView.hours_display.text = "Speed(km/h) : ${ftn.ftn_speed.toString()}"

        holder.itemView.hours_cal.text = "Kcal burned : ${ftn.ftn_cal.toString()}"

        holder.itemView.display_active.text = "Active Time : ${ftn.ftn_acttime.toString()}"

    }
}
