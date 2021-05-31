package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.AlphabetFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.AlphabetData
import org.ohmstheresistance.milabila.recyclerview.AlphabetAdapter

class AlphabetFragment : Fragment(), AlphabetAdapter.UpdateDetailTextviewInterface {

    private val letterList = listOf(
        AlphabetData(R.drawable.a, "Aa", "Alligator"),
        AlphabetData(R.drawable.b, "Bb", "Bear"),
        AlphabetData(R.drawable.c, "Cc", "Cat"),
        AlphabetData(R.drawable.d, "Dd", "Dog"),
        AlphabetData(R.drawable.e, "Ee", "Elephant"),
        AlphabetData(R.drawable.f, "Ff", "Fire"),
        AlphabetData(R.drawable.g, "Gg", "Giraffe"),
        AlphabetData(R.drawable.h, "Hh", "Horse"),
        AlphabetData(R.drawable.i, "Ii", "Iguana"),
        AlphabetData(R.drawable.j, "Jj", "Jellyfish"),
        AlphabetData(R.drawable.k, "Kk", "Koala"),
        AlphabetData(R.drawable.l, "Ll", "Lion"),
        AlphabetData(R.drawable.m, "Mm", "Monkey"),
        AlphabetData(R.drawable.n, "Nn", "Narwhal"),
        AlphabetData(R.drawable.o, "Oo", "Owl"),
        AlphabetData(R.drawable.p, "Pp", "Pig"),
        AlphabetData(R.drawable.q, "Qq", "Quail"),
        AlphabetData(R.drawable.r, "Rr", "Rabbit"),
        AlphabetData(R.drawable.s, "Ss", "Snake"),
        AlphabetData(R.drawable.t, "Tt", "Tiger"),
        AlphabetData(R.drawable.u, "Uu", "Unicorn"),
        AlphabetData(R.drawable.v, "Vv", "Vulture"),
        AlphabetData(R.drawable.w, "Ww", "Worm"),
        AlphabetData(R.drawable.x, "Xx", "X-ray"),
        AlphabetData(R.drawable.y, "Yy", "Yak"),
        AlphabetData(R.drawable.z, "Zz", "Zebra")
    )
    private val alphabetAdapter = AlphabetAdapter(letterList, this)
    lateinit var alphabetFragmentBinding: AlphabetFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        alphabetFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.alphabet_fragment,
            container,
            false
        )

        setUpLettersRecyclerView()

        return alphabetFragmentBinding.root
    }

    private fun setUpLettersRecyclerView() {
        alphabetFragmentBinding.alphabetListRecycler.layoutManager = GridLayoutManager(context, 4)
        alphabetFragmentBinding.alphabetListRecycler.adapter = alphabetAdapter
    }

    override fun updateText(letter: String, comparisonWord: String) {
        alphabetFragmentBinding.detailTextview.text = letter + " is for " + comparisonWord
    }
}