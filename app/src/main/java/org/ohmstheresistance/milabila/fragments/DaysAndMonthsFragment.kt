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
import org.ohmstheresistance.milabila.recyclerview.DaysAndMonthAdapter

class DaysAndMonthsFragment : Fragment() {

    private val dayList = listOf(
        DaysData("Sunday"),
        DaysData("Monday"),
        DaysData("Tuesday"),
        DaysData("Wednesday"),
        DaysData("Thursday"),
        DaysData("Friday"),
        DaysData("Saturday"))

    lateinit var daysAndMonthsFragmentBinding: DaysAndMonthsFragmentBinding
    private val daysAndMonthAdapter = DaysAndMonthAdapter(dayList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        daysAndMonthsFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.days_and_months_fragment, container, false)

        setUpDaysRecyclerView()

        return daysAndMonthsFragmentBinding.root
    }

    private fun setUpDaysRecyclerView() {
        daysAndMonthsFragmentBinding.dayListRecycler.layoutManager = GridLayoutManager(context, 4)
        daysAndMonthsFragmentBinding.dayListRecycler.adapter = daysAndMonthAdapter
    }

}