package org.ohmstheresistance.milabila.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.AlphabetData
import org.ohmstheresistance.milabila.fragments.AlphabetFragment

class AlphabetAdapter(private val letterList: List<AlphabetData>, val alphabetFragment: AlphabetFragment)  :RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_itemview, parent, false)


        return AlphabetViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        holder.bindItems(letterList[position])

        val positionOfLetterClicked = position

        val letterClicked = letterList[position].letterCapitalAndCommon
        val detailImageName = letterList[position].detailImageName

        holder.itemView.setOnClickListener {

            Log.d("Item", position.toString())
            Log.d("tryna see",letterList[position].letterCapitalAndCommon + " is for " + letterList[position].detailImageName)


            alphabetFragment.updateTextAndImages(letterClicked, detailImageName, positionOfLetterClicked)

        }
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(alphabetDataInfo: AlphabetData) {
            val letterImage: ImageView = itemView.findViewById(R.id.letter_imageview) as ImageView
            letterImage.setImageResource(alphabetDataInfo.letterImage)

        }
    }
    interface UpdateDetailTextviewInterface {
        fun updateTextAndImages(letter: String, comparisonWord: String, positionOfLetterClicked: Int)
    }
}
