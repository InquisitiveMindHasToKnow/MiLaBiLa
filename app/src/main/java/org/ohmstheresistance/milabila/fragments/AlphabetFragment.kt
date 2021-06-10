package org.ohmstheresistance.milabila.fragments

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
import org.ohmstheresistance.milabila.databinding.AlphabetFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.AlphabetData
import org.ohmstheresistance.milabila.recyclerview.AlphabetAdapter
import java.util.*

class AlphabetFragment : Fragment(), AlphabetAdapter.UpdateDetailTextviewInterface,
    TextToSpeech.OnInitListener {

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
    lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        alphabetFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.alphabet_fragment,
            container,
            false
        )
        textToSpeech = TextToSpeech(context, this)

        setUpLettersRecyclerView()

        return alphabetFragmentBinding.root
    }

    private fun setUpLettersRecyclerView() {

        val layoutManager = GridLayoutManager(activity, 4)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    letterList.size -1, letterList.size -2 -> 2
                    else -> 1
                }
            }
        }
        alphabetFragmentBinding.alphabetListRecycler.layoutManager = layoutManager
        alphabetFragmentBinding.alphabetListRecycler.adapter = alphabetAdapter
    }

    override fun updateTextAndImages(
        letter: String,
        comparisonWord: String,
        positionOfLetterClicked: Int
    ) {
        val sentenceToSay =  letter.substring(1) + " is for " + comparisonWord
        val sentenceToDisplay = resources.getString(R.string.alphabet_frag_display_text, letter, comparisonWord)
        textToSpeech.speak(sentenceToSay, TextToSpeech.QUEUE_FLUSH, null)


        alphabetFragmentBinding.detailTextview.text = sentenceToDisplay

        for (i in letterList.indices) {
            alphabetFragmentBinding.selectedLetterImageview.setImageResource(letterList[positionOfLetterClicked].letterImage)
            alphabetFragmentBinding.letterComparisonImageview.setImageResource(letterList[positionOfLetterClicked].detailImage)
        }
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
