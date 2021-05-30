package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.NumbersFragmentBinding

class NumbersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val numbersFragmentBinding = DataBindingUtil.inflate<NumbersFragmentBinding>(inflater, R.layout.numbers_fragment, container, false)

        return numbersFragmentBinding.root
    }
}