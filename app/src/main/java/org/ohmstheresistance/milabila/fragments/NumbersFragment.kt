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
import org.ohmstheresistance.milabila.databinding.NumbersFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.NumbersData
import org.ohmstheresistance.milabila.recyclerview.NumbersAdapter
import java.util.*

class NumbersFragment : Fragment(), NumbersAdapter.UpdateNumberDetailsInterface,
    TextToSpeech.OnInitListener {

    private val numberList = listOf(
        NumbersData("One", R.drawable.number_one, R.drawable.one_count, " finger"),
        NumbersData("Two", R.drawable.nunber_two, R.drawable.two_count, " fingers"),
        NumbersData("Three", R.drawable.number_three, R.drawable.three_count, " fingers"),
        NumbersData("Four", R.drawable.number_four, R.drawable.four_count, " fingers"),
        NumbersData("Five", R.drawable.number_five, R.drawable.five_count, " fingers"),
        NumbersData("Six", R.drawable.number_six, R.drawable.six_count, " fingers"),
        NumbersData("Seven", R.drawable.number_seven, R.drawable.seven_count, " fingers"),
        NumbersData("Eight", R.drawable.number_eight, R.drawable.eight_count, " fingers"),
        NumbersData("Nine", R.drawable.number_nine, R.drawable.nine_count, " fingers"),
        NumbersData("Ten", R.drawable.number_ten, R.drawable.ten_count, " fingers"),
        NumbersData("Eleven", R.drawable.number_eleven, R.drawable.eleven_count, " Mo Annas"),
        NumbersData("Twelve", R.drawable.number_twelve, R.drawable.twelve_count, " pans"),
        NumbersData("Thirteen", R.drawable.number_thirteen, R.drawable.thirteen_count, " strawberry donuts"),
        NumbersData("Fourteen", R.drawable.number_fourteen, R.drawable.fourteen_count, " lady bugs"),
        NumbersData("Fifteen", R.drawable.number_fifteen, R.drawable.fifteen_count, " chocolate donuts"),
        NumbersData("Sixteen", R.drawable.number_sixteen, R.drawable.sixteen_count, " crowns"),
        NumbersData("Seventeen", R.drawable.number_seventeen, R.drawable.seventeen_count, " candies"),
        NumbersData("Eighteen", R.drawable.number_eighteen, R.drawable.eighteen_count, " Nemos"),
        NumbersData("Nineteen", R.drawable.number_nineteen, R.drawable.nineteen_count, " pans"),
        NumbersData("Twenty", R.drawable.number_twenty, R.drawable.twenty_count, " grinches"),
    )

    lateinit var numbersFragmentBinding: NumbersFragmentBinding
    private val numbersAdapter = NumbersAdapter(numberList, this)
    lateinit var textToSpeech: TextToSpeech


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        numbersFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.numbers_fragment, container, false)

        textToSpeech = TextToSpeech(context, this)

        setUpNumbersRecyclerView()

        return numbersFragmentBinding.root
    }

    private fun setUpNumbersRecyclerView() {
        numbersFragmentBinding.numberListRecycler.layoutManager = GridLayoutManager(context, 5)
        numbersFragmentBinding.numberListRecycler.adapter = numbersAdapter
    }

    override fun updateNumberTextAndImages(
        numberName: String,
        numberImage: Int,
        numberCountImage: Int,
        countedImageName: String

    ) {


        var isOrAre = "There is..."

        isOrAre = if(numberName.equals("One")){

            "There is "

        }else{
            "There are "
        }

        val sentenceToSay = numberName + ". " + isOrAre + numberName + countedImageName
        val sentenceToDisplay = isOrAre + numberName + countedImageName + "."

        textToSpeech.speak(sentenceToSay, TextToSpeech.QUEUE_FLUSH, null)

        numbersFragmentBinding.theNumbersFragmentHeaderTextview.text = numberName
        numbersFragmentBinding.selectedNumberImageview.setImageResource(numberImage)
        numbersFragmentBinding.numberComparisonImageview.setImageResource(numberCountImage)

        when (numberName) {
            "One","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty" -> {
                numbersFragmentBinding.numberDetailTextview.text = sentenceToDisplay

            }
        }
    }

    override fun onInit(textToSpeechInitialized: Int) {
        if (textToSpeechInitialized == TextToSpeech.SUCCESS) {
            val res: Int = textToSpeech.setLanguage(Locale.ENGLISH)
            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(context, "Unsupported language.", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(context, "Text to speech initialization failed.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(textToSpeech != null){
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }
}
