package org.ohmstheresistance.milabila.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ColorFragmentBinding

class ColorFragment : Fragment(), View.OnClickListener {

    lateinit var colorFragmentBinding: ColorFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        colorFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.color_fragment, container, false)

        setUpButtonClickListeners()


        return colorFragmentBinding.root

    }

    override fun onClick(view: View?) {

        when(view?.id){
            colorFragmentBinding.redButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#FF0000"))}
            colorFragmentBinding.blueButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#0000FF"))}
            colorFragmentBinding.yellowButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#FFFF00"))}
            colorFragmentBinding.purpleButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#800080"))}
            colorFragmentBinding.greenButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#008000"))}
            colorFragmentBinding.orangeButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#FFA500"))}
            colorFragmentBinding.blackButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#000000"))}
            colorFragmentBinding.pinkButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#FFC0CB"))}
            colorFragmentBinding.brownButton.id -> {colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor(Color.parseColor("#88540B"))}

            else -> {
            colorFragmentBinding.colorFragTopHalfLinear.setBackgroundColor("FFF".toInt())
        }

            }
        }
    private fun setUpButtonClickListeners(){
        colorFragmentBinding.redButton.setOnClickListener(this)
        colorFragmentBinding.blueButton.setOnClickListener(this)
        colorFragmentBinding.yellowButton.setOnClickListener(this)
        colorFragmentBinding.purpleButton.setOnClickListener(this)
        colorFragmentBinding.greenButton.setOnClickListener(this)
        colorFragmentBinding.orangeButton.setOnClickListener(this)
        colorFragmentBinding.blackButton.setOnClickListener(this)
        colorFragmentBinding.pinkButton.setOnClickListener(this)
        colorFragmentBinding.brownButton.setOnClickListener(this)
    }
    }