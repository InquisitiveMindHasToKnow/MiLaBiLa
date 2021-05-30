package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.AlphabetData


class AlphabetAdapter(private val letterList: ArrayList<AlphabetData>) :
    RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_itemview, parent, false)

        return AlphabetViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        holder.bindItems(letterList[position])
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(alphabetDataInfo: AlphabetData) {
            val letterImage: ImageView = itemView.findViewById(R.id.letter_imageview) as ImageView
            letterImage.setImageResource(alphabetDataInfo.letter)
        }
    }
}