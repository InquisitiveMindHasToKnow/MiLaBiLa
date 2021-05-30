package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ColorFragmentBinding

class ColorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val colorFragmentBinding = DataBindingUtil.inflate<ColorFragmentBinding>(inflater, R.layout.color_fragment, container, false)


        return colorFragmentBinding.root

    }
}