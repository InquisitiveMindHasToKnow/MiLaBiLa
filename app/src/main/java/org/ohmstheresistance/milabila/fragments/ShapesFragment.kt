package org.ohmstheresistance.milabila.fragments

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ShapesFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.ShapeData
import org.ohmstheresistance.milabila.recyclerview.ShapesAdapter
import java.util.*

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
    ShapeData(R.drawable.triangle, "Triangle"),
    ShapeData(R.drawable.star, "Star"),
    ShapeData(R.drawable.cross, "Cross")
)




class ShapesFragment : Fragment(), ShapesAdapter.ShapesViewHolder.UpdateShapeImageAndNameInterface, TextToSpeech.OnInitListener {

    lateinit var shapesFragmentBinding: ShapesFragmentBinding
    lateinit var textToSpeech: TextToSpeech
    private val shapesAdapter = ShapesAdapter(shapesList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       shapesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shapes_fragment, container, false)

        textToSpeech = TextToSpeech(context, this)

        setUpLettersRecyclerView()

        return shapesFragmentBinding.root
    }

    private fun setUpLettersRecyclerView() {
        shapesFragmentBinding.shapesRecycler.layoutManager = GridLayoutManager(context, 4)
        shapesFragmentBinding.shapesRecycler.adapter = shapesAdapter
    }

    override fun updateShapeImageAndName(clickedShapeName: String, clickedShapeImage: Int) {

        val colors = listOf("#FF0000", "#0000FF", "#FFFF00", "#800080", "#008000", "#FFA500", "#FFC0CB", "#88540B", "#808080", "#800000")

        for(i in colors.indices){
            var colorPicked = colors.random()


            shapesFragmentBinding.shapesfragShapeImageview.setBackgroundColor(Color.parseColor(colorPicked))
            shapesFragmentBinding.shapefragShapeNameTextview.setTextColor(Color.parseColor(colorPicked))

            when(colorPicked){
                "#FF0000" -> { colorPicked = "Red" }
                "#0000FF" -> { colorPicked ="Blue"}
                "#FFFF00" -> { colorPicked ="Yellow"}
                "#800080" -> { colorPicked ="Purple"}
                "#008000" -> { colorPicked ="Green"}
                "#FFA500" -> { colorPicked ="Orange"}
                "#FFC0CB" -> { colorPicked ="Pink"}
                "#88540B" -> { colorPicked ="Brown"}
                "#800000" -> { colorPicked ="Maroon"}
                "#808080" -> { colorPicked = "Gray"}
            }
            val sentenceToSay = clickedShapeName + ". The " + clickedShapeName + " is " + colorPicked
            val sentenceToDisplay = "The " + clickedShapeName + " is " + colorPicked + "."
            shapesFragmentBinding.selectedImageNameAndColorTextview.text = sentenceToDisplay

            textToSpeech.speak(sentenceToSay, TextToSpeech.QUEUE_FLUSH, null)

        }

        for (i in shapesList.indices){
            shapesFragmentBinding.shapesfragShapeImageview.setImageResource(clickedShapeImage)
        }

        shapesFragmentBinding.shapefragShapeNameTextview.text = clickedShapeName

    }

    override fun onInit(textToSpeechInitialized: Int) {
        if (textToSpeechInitialized == TextToSpeech.SUCCESS) {
            val res: Int = textToSpeech.setLanguage(Locale.ENGLISH)
            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(context, "Unsupported language.", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(context, "Text to speech initialization failed.", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (textToSpeech != null) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }
}
//    private fun changeImageViewBackgroundColor(){
//        val colors = listOf("#FF0000", "#0000FF", "#FFFF00", "#800080", "#008000", "#FFA500", "#FFC0CB", "#88540B", "#808080", "#800000")
//
//        for(i in colors.indices){
//           val colorPicked = colors.random()
//            shapesFragmentBinding.shapesfragShapeImageview.setBackgroundColor(Color.parseColor(colorPicked))
//            shapesFragmentBinding.shapefragShapeNameTextview.setTextColor(Color.parseColor(colorPicked))
//
//        }
//    }
