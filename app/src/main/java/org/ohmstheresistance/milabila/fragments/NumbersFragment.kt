package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.NumbersFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.NumbersData
import org.ohmstheresistance.milabila.recyclerview.NumbersAdapter

class NumbersFragment : Fragment(), NumbersAdapter.UpdateNumberDetailsInterface {

    private val numberList = listOf(
        NumbersData("One", R.drawable.number_one, R.drawable.one_count),
        NumbersData("Two", R.drawable.nunber_two, R.drawable.two_count),
        NumbersData("Three", R.drawable.number_three, R.drawable.three_count),
        NumbersData("Four", R.drawable.number_four, R.drawable.four_count),
        NumbersData("Five", R.drawable.number_five, R.drawable.five_count),
        NumbersData("Six", R.drawable.number_six, R.drawable.six_count),
        NumbersData("Seven", R.drawable.number_seven, R.drawable.seven_count),
        NumbersData("Eight", R.drawable.number_eight, R.drawable.eight_count),
        NumbersData("Nine", R.drawable.number_nine, R.drawable.nine_count),
        NumbersData("Ten", R.drawable.number_ten, R.drawable.ten_count))

    lateinit var numbersFragmentBinding: NumbersFragmentBinding
    private val numbersAdapter = NumbersAdapter(numberList, this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         numbersFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.numbers_fragment, container, false)

        setUpNumbersRecyclerView()

        return numbersFragmentBinding.root
    }

    private fun setUpNumbersRecyclerView() {
        numbersFragmentBinding.numberListRecycler.layoutManager = GridLayoutManager(context, 5)
        numbersFragmentBinding.numberListRecycler.adapter = numbersAdapter
    }

    override fun updateNumberTextAndImages(numberName: String, numberImage: Int, numberCountImage: Int) {
        numbersFragmentBinding.theNumbersFragmentHeaderTextview.text = numberName
        numbersFragmentBinding.selectedNumberImageview.setImageResource(numberImage)
        numbersFragmentBinding.numberComparisonImageview.setImageResource(numberCountImage)

        when(numberName){
            "One" -> {numbersFragmentBinding.numberDetailTextview.text = "There is" + numberName + " finger."}
            "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" -> {numbersFragmentBinding.numberDetailTextview.text = "There are " + numberName + " fingers."}
        }
    }
}