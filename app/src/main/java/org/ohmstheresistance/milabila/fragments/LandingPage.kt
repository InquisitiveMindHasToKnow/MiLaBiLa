package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.LandingPageFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.AlphabetData
import org.ohmstheresistance.milabila.recyclerview.AlphabetAdapter

class LandingPage : Fragment() {

    private val letterList = ArrayList<AlphabetData>()
    private val alphabetAdapter = AlphabetAdapter(letterList)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<LandingPageFragmentBinding>(inflater, R.layout.landing_page_fragment, container, false)

//        binding.alphabetListRecycler.layoutManager = GridLayoutManager(context, 4)
//        binding.alphabetListRecycler.adapter = alphabetAdapter

        addLetters()
        return binding.root
    }

    private fun addLetters(){

        letterList.add(AlphabetData(R.drawable.a))
        letterList.add(AlphabetData(R.drawable.b))
        letterList.add(AlphabetData(R.drawable.c))
        letterList.add(AlphabetData(R.drawable.d))
        letterList.add(AlphabetData(R.drawable.e))
        letterList.add(AlphabetData(R.drawable.f))
        letterList.add(AlphabetData(R.drawable.g))
        letterList.add(AlphabetData(R.drawable.h))
        letterList.add(AlphabetData(R.drawable.i))
        letterList.add(AlphabetData(R.drawable.j))
        letterList.add(AlphabetData(R.drawable.k))
        letterList.add(AlphabetData(R.drawable.l))
        letterList.add(AlphabetData(R.drawable.m))
        letterList.add(AlphabetData(R.drawable.n))
        letterList.add(AlphabetData(R.drawable.o))
        letterList.add(AlphabetData(R.drawable.p))
        letterList.add(AlphabetData(R.drawable.q))
        letterList.add(AlphabetData(R.drawable.r))
        letterList.add(AlphabetData(R.drawable.s))
        letterList.add(AlphabetData(R.drawable.t))
        letterList.add(AlphabetData(R.drawable.u))
        letterList.add(AlphabetData(R.drawable.v))
        letterList.add(AlphabetData(R.drawable.w))
        letterList.add(AlphabetData(R.drawable.x))
        letterList.add(AlphabetData(R.drawable.y))
        letterList.add(AlphabetData(R.drawable.z))


    }
}