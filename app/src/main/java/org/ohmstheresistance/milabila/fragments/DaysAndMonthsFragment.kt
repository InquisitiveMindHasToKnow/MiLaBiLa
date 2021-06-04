package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.DaysAndMonthsFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.DaysData
import org.ohmstheresistance.milabila.dataclasses.MonthsData
import org.ohmstheresistance.milabila.recyclerview.DaysAdapter
import org.ohmstheresistance.milabila.recyclerview.MonthsAdapter

class DaysAndMonthsFragment : Fragment(), DaysAdapter.UpdateDaySelectedTextviewInterface, MonthsAdapter.UpdateMonthNameTextviewInterface{

    private val dayList = listOf(
        DaysData("Sunday"),
        DaysData("Monday"),
        DaysData("Tuesday"),
        DaysData("Wednesday"),
        DaysData("Thursday"),
        DaysData("Friday"),
        DaysData("Saturday"))

    private val monthList = listOf(
       MonthsData("January"),
        MonthsData("February"),
        MonthsData("March"),
        MonthsData("April"),
        MonthsData("May"),
        MonthsData("June"),
        MonthsData("July"),
        MonthsData("August"),
        MonthsData("September"),
        MonthsData("October"),
        MonthsData("November"),
        MonthsData("December"))

    lateinit var daysAndMonthsFragmentBinding: DaysAndMonthsFragmentBinding
    private val daysAdapter = DaysAdapter(dayList, this)
    private val monthsAdapter = MonthsAdapter(monthList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        daysAndMonthsFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.days_and_months_fragment, container, false)

        setUpDaysAndMonthsRecyclerView()

        return daysAndMonthsFragmentBinding.root
    }

    private fun setUpDaysAndMonthsRecyclerView() {
        daysAndMonthsFragmentBinding.dayListRecycler.layoutManager = GridLayoutManager(context, 3)
        daysAndMonthsFragmentBinding.dayListRecycler.adapter = daysAdapter

        daysAndMonthsFragmentBinding.monthListRecycler.layoutManager = GridLayoutManager(context, 4)
        daysAndMonthsFragmentBinding.monthListRecycler.adapter = monthsAdapter
    }

    override fun updateDayNameText(dayName: String) {
        daysAndMonthsFragmentBinding.dayOrMonthSelectedTextview.text = dayName
    }

    override fun updateMonthNameText(monthName: String) {
        daysAndMonthsFragmentBinding.dayOrMonthSelectedTextview.text = monthName
    }

}