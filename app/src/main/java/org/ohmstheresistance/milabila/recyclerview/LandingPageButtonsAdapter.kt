package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.LandingPageButtonsData
import org.ohmstheresistance.milabila.fragments.LandingPageDirections

class LandingPageButtonsAdapter(private val buttonNameList: List<LandingPageButtonsData>):RecyclerView.Adapter<LandingPageButtonsAdapter.LandingPageButtonsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandingPageButtonsViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.landing_page_buttons_itemview, parent, false)

        return LandingPageButtonsViewHolder(v)
    }

    override fun onBindViewHolder(holder: LandingPageButtonsViewHolder, position: Int) {
        holder.bindItems(buttonNameList[position])

        val buttonClicked = buttonNameList[position].landingPageButtonName

        holder.itemView.setOnClickListener {
            when (buttonClicked) {
                "Alphabet" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToAlphabetFragment())
                "Numbers" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToNumbersFragment())
                "Weather" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToWeatherFragment())
                "Colors" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToColorFragment())
                "Shapes" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToShapesFragment())
                "Days\nAnd\nMonths" -> holder.itemView.findNavController().navigate(LandingPageDirections.actionLandingPageToDaysAndMonthsFragment22())
            }
        }
    }

    override fun getItemCount(): Int {
        return buttonNameList.size
    }

    class LandingPageButtonsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(landingPageButtonsData: LandingPageButtonsData) {
            val buttonNames = landingPageButtonsData.landingPageButtonName

            val buttons: TextView = itemView.findViewById(R.id.landing_page_buttons_textview)
            buttons.text = buttonNames

        }
    }
}