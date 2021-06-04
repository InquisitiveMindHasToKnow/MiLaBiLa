package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.DaysData
import org.ohmstheresistance.milabila.fragments.DaysAndMonthsFragment

class DaysAdapter(private val dayList: List<DaysData>,
                  private val daysAndMonthsFragment: DaysAndMonthsFragment
) :
    RecyclerView.Adapter<DaysAdapter.DaysViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.days_itemview, parent, false)

        return DaysViewHolder(v)
    }

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        holder.bindItems(dayList[position])

        val dayClicked = dayList[position].dayName

        holder.itemView.setOnClickListener {

            daysAndMonthsFragment.updateDayNameText(dayClicked)
        }
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    class DaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(daysData: DaysData) {
            val days = daysData.dayName

            val dayName: TextView = itemView.findViewById(R.id.day_name_textview)
            dayName.text = days
        }
    }
    interface UpdateDaySelectedTextviewInterface {
        fun updateDayNameText(dayName: String)
    }
}