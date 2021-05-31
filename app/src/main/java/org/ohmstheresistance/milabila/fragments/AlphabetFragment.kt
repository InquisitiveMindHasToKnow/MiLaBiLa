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
        AlphabetData(R.drawable.a, "Aa", "Alligator", R.drawable.alligator),
        AlphabetData(R.drawable.b, "Bb", "Bear", R.drawable.bear),
        AlphabetData(R.drawable.c, "Cc", "Cat", R.drawable.cat),
        AlphabetData(R.drawable.d, "Dd", "Dog", R.drawable.dog),
        AlphabetData(R.drawable.e, "Ee", "Elephant", R.drawable.elephant),
        AlphabetData(R.drawable.f, "Ff", "Flamingo", R.drawable.flamingo),
        AlphabetData(R.drawable.g, "Gg", "Giraffe", R.drawable.giraffe),
        AlphabetData(R.drawable.h, "Hh", "Horse", R.drawable.horse),
        AlphabetData(R.drawable.i, "Ii", "Iguana", R.drawable.iguana),
        AlphabetData(R.drawable.j, "Jj", "Jellyfish", R.drawable.jellyfish),
        AlphabetData(R.drawable.k, "Kk", "Koala", R.drawable.koala),
        AlphabetData(R.drawable.l, "Ll", "Lion", R.drawable.lion),
        AlphabetData(R.drawable.m, "Mm", "Monkey", R.drawable.monkey),
        AlphabetData(R.drawable.n, "Nn", "Narwhal", R.drawable.narwhal),
        AlphabetData(R.drawable.o, "Oo", "Owl", R.drawable.owl),
        AlphabetData(R.drawable.p, "Pp", "Pig", R.drawable.pig),
        AlphabetData(R.drawable.q, "Qq", "Quail", R.drawable.quail),
        AlphabetData(R.drawable.r, "Rr", "Rabbit", R.drawable.rabbit),
        AlphabetData(R.drawable.s, "Ss", "Snake", R.drawable.snake),
        AlphabetData(R.drawable.t, "Tt", "Tiger", R.drawable.tiger),
        AlphabetData(R.drawable.u, "Uu", "Unicorn", R.drawable.unicorn),
        AlphabetData(R.drawable.v, "Vv", "Vulture", R.drawable.vulture),
        AlphabetData(R.drawable.w, "Ww", "Worm", R.drawable.worm),
        AlphabetData(R.drawable.x, "Xx", "X-ray", R.drawable.xray),
        AlphabetData(R.drawable.y, "Yy", "Yak", R.drawable.yak),
        AlphabetData(R.drawable.z, "Zz", "Zebra", R.drawable.zebra)
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

    override fun updateTextAndImages(letter: String, comparisonWord: String, positionOfLetterClicked: Int) {
        alphabetFragmentBinding.detailTextview.text = letter + " is for " + comparisonWord


       for (i in letterList.indices){
            alphabetFragmentBinding.selectedLetterImageview.setImageResource(letterList[positionOfLetterClicked].letterImage)
            alphabetFragmentBinding.letterComparisonImageview.setImageResource(letterList[positionOfLetterClicked].detailImage)
        }
    }
}