package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.NumbersData
import org.ohmstheresistance.milabila.fragments.NumbersFragment

class NumbersAdapter(private val numberList: List<NumbersData>, private val numbersFragment: NumbersFragment):
    RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.number_itemview, parent, false)

        return NumbersViewHolder(v)
    }
    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bindItems(numberList[position])

        val numberClicked = numberList[position].numberName
        val numberClickedImage = numberList[position].numberImage
        val numberClickedCount = numberList[position].numberCountImage
        val nameOfCountedItem = numberList[position].nameOfCountedItemsOnImage

        holder.itemView.setOnClickListener {
            numbersFragment.updateNumberTextAndImages(
                numberClicked,
                numberClickedImage,
                numberClickedCount,
                nameOfCountedItem
            )
        }
    }
    override fun getItemCount(): Int {
        return numberList.size
    }

    class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(numbersData: NumbersData) {
            val letterImage: ImageView = itemView.findViewById(R.id.number_imageview) as ImageView
            letterImage.setImageResource(numbersData.numberImage)

        }
    }
    interface UpdateNumberDetailsInterface {
        fun updateNumberTextAndImages(numberName: String, numberImage: Int, numberCountImage: Int, countedImageName: String)
    }
}
