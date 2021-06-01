package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.ShapeData
import org.ohmstheresistance.milabila.fragments.ShapesFragment

class ShapesAdapter(private val shapesList: List<ShapeData>, val shapeFragment: ShapesFragment) :
    RecyclerView.Adapter<ShapesAdapter.ShapesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapesViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.shape_itemview, parent, false)


        return ShapesViewHolder(v)
    }


    override fun onBindViewHolder(holder: ShapesViewHolder, position: Int) {
        holder.bindItems(shapesList[position])

        val shapeClicked = shapesList[position].shapeImage
        val shapeName = shapesList[position].shapeName

        holder.itemView.setOnClickListener {

            shapeFragment.updateShapeImageAndName(shapeName, shapeClicked)
        }
    }

    override fun getItemCount(): Int {
        return shapesList.size
    }

    class ShapesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(shapeData: ShapeData) {
            val letterImage: ImageView = itemView.findViewById(R.id.shape_imageview) as ImageView
            letterImage.setImageResource(shapeData.shapeImage)
        }

        interface UpdateShapeImageAndNameInterface {
            fun updateShapeImageAndName(clickedShapeName: String, clickedShapeImage: Int)
        }
    }
}