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
import org.ohmstheresistance.milabila.databinding.DaysAndMonthsFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.DaysData
import org.ohmstheresistance.milabila.dataclasses.MonthsData
import org.ohmstheresistance.milabila.recyclerview.DaysAdapter
import org.ohmstheresistance.milabila.recyclerview.MonthsAdapter
import java.util.*

class DaysAndMonthsFragment : Fragment(), DaysAdapter.UpdateDaySelectedTextviewInterface, MonthsAdapter.UpdateMonthNameTextviewInterface,
    TextToSpeech.OnInitListener{

    private val dayList = listOf(
        DaysData("Sunday", "first"),
        DaysData("Monday", "second"),
        DaysData("Tuesday", "third"),
        DaysData("Wednesday", "fourth"),
        DaysData("Thursday", "fifth"),
        DaysData("Friday", "sixth"),
        DaysData("Saturday", "seventh"))

    private val monthList = listOf(
       MonthsData("January", "first"),
        MonthsData("February", "second"),
        MonthsData("March", "third"),
        MonthsData("April", "fourth"),
        MonthsData("May", "fifth"),
        MonthsData("June", "sixth"),
        MonthsData("July", "seventh"),
        MonthsData("August", "eighth"),
        MonthsData("September", "ninth"),
        MonthsData("October", "tenth"),
        MonthsData("November", "eleventh"),
        MonthsData("December", "twelfth"))

    private lateinit var daysAndMonthsFragmentBinding: DaysAndMonthsFragmentBinding
    private val daysAdapter = DaysAdapter(dayList, this)
    private val monthsAdapter = MonthsAdapter(monthList, this)
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        daysAndMonthsFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.days_and_months_fragment, container, false)
        textToSpeech = TextToSpeech(context, this)

        setUpDaysAndMonthsRecyclerView()

        return daysAndMonthsFragmentBinding.root
    }

    private fun setUpDaysAndMonthsRecyclerView() {

        val layoutManager = GridLayoutManager(activity, 3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    dayList.size -1 -> 3
                    else -> 1
                }
            }
        }
        daysAndMonthsFragmentBinding.dayListRecycler.layoutManager = layoutManager
        daysAndMonthsFragmentBinding.dayListRecycler.adapter = daysAdapter

        daysAndMonthsFragmentBinding.monthListRecycler.layoutManager = GridLayoutManager(context, 4)
        daysAndMonthsFragmentBinding.monthListRecycler.adapter = monthsAdapter
    }

    override fun updateDayNameText(dayName: String, positionOfDay: String) {
        val sentenceToSpeakForDay = dayName + ". " + dayName + " is the " + positionOfDay + " day of the week."
        val sentenceToDisplayForDay = dayName + " is the " + positionOfDay + " day of the week."

        daysAndMonthsFragmentBinding.detailTextview.text = sentenceToDisplayForDay
        daysAndMonthsFragmentBinding.dayOrMonthSelectedTextview.text = dayName
        textToSpeech.speak(sentenceToSpeakForDay, TextToSpeech.QUEUE_FLUSH, null)

    }

    override fun updateMonthNameText(monthName: String, positionOfMonth: String ) {
        val sentenceToSpeakForMonth = monthName + ". " + monthName + " is the " + positionOfMonth + " month of the year."
        val sentenceToDisplayForMonth = monthName + " is the " + positionOfMonth +  " month of the year."

        daysAndMonthsFragmentBinding.detailTextview.text = sentenceToDisplayForMonth
        daysAndMonthsFragmentBinding.dayOrMonthSelectedTextview.text = monthName
        textToSpeech.speak(sentenceToSpeakForMonth, TextToSpeech.QUEUE_FLUSH, null)

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