package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.MonthsData
import org.ohmstheresistance.milabila.fragments.DaysAndMonthsFragment

class MonthsAdapter (private val monthList: List<MonthsData>, private val daysAndMonthsFragment: DaysAndMonthsFragment) :
RecyclerView.Adapter<MonthsAdapter.MonthsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthsViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.months_itemview, parent, false)

        return MonthsViewHolder(v)
    }

    override fun onBindViewHolder(holder: MonthsViewHolder, position: Int) {
        holder.bindItems(monthList[position])

        val monthClicked = monthList[position].monthName
        val monthPosition = monthList[position].positionOfMonthInYear

        holder.itemView.setOnClickListener {

            daysAndMonthsFragment.updateMonthNameText(monthClicked, monthPosition)
        }
    }

    override fun getItemCount(): Int {
        return monthList.size
    }

    class MonthsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(monthsData: MonthsData) {
            val months = monthsData.monthName

            val monthName: TextView = itemView.findViewById(R.id.month_name_textview)
            monthName.text = months
        }
    }
    interface UpdateMonthNameTextviewInterface {
        fun updateMonthNameText(monthName: String, positionOfMonth: String)
    }
}