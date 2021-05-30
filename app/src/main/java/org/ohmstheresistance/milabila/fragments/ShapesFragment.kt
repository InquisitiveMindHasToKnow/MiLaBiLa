package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ShapesFragmentBinding

class ShapesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val shapesFragmentBinding = DataBindingUtil.inflate<ShapesFragmentBinding>(inflater, R.layout.shapes_fragment, container, false)

        return shapesFragmentBinding.root
    }
}