package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ShapesFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.ShapeData
import org.ohmstheresistance.milabila.recyclerview.ShapesAdapter

private val shapesList = listOf(
    ShapeData(R.drawable.square, "Square"),
    ShapeData(R.drawable.circle_shape, "Circle"),
    ShapeData(R.drawable.rectangle, "Rectangle"),
    ShapeData(R.drawable.cube, "Cube"),
    ShapeData(R.drawable.heart, "Heart"),
    ShapeData(R.drawable.diamond, "Diamond"),
    ShapeData(R.drawable.hexagon, "Hexagon"),
    ShapeData(R.drawable.pentagon, "Pentagon"),
    ShapeData(R.drawable.octagon, "Octagon"),
    ShapeData(R.drawable.triangle, "Triangle"))



class ShapesFragment : Fragment(), ShapesAdapter.ShapesViewHolder.UpdateShapeImageAndNameInterface {

    lateinit var shapesFragmentBinding: ShapesFragmentBinding
    private val shapesAdapter = ShapesAdapter(shapesList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       shapesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shapes_fragment, container, false)

        setUpLettersRecyclerView()

        return shapesFragmentBinding.root
    }

    private fun setUpLettersRecyclerView() {
        shapesFragmentBinding.shapesRecycler.layoutManager = GridLayoutManager(context, 5)
        shapesFragmentBinding.shapesRecycler.adapter = shapesAdapter
    }

    override fun updateShapeImageAndName(clickedShapeName: String, clickedShapeImage: Int) {
        shapesFragmentBinding.shapefragShapeNameTextview.text = clickedShapeName

        for (i in shapesList.indices){
            shapesFragmentBinding.shapesfragShapeImageview.setImageResource(clickedShapeImage)
        }
    }
}