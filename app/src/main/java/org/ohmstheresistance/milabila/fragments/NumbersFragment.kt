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
        NumbersData("Ten", R.drawable.number_ten, R.drawable.ten_count),
        NumbersData("Eleven", R.drawable.number_eleven, R.drawable.eleven_count),
        NumbersData("Twelve", R.drawable.number_twelve, R.drawable.twelve_count),
        NumbersData("Thirteen", R.drawable.number_thirteen, R.drawable.thirteen_count),
        NumbersData("Fourteen", R.drawable.number_fourteen, R.drawable.fourteen_count),
        NumbersData("Fifteen", R.drawable.number_fifteen, R.drawable.fifteen_count),
        NumbersData("Sixteen", R.drawable.number_sixteen, R.drawable.sixteen_count),
        NumbersData("Seventeen", R.drawable.number_seventeen, R.drawable.seventeen_count),
        NumbersData("Eighteen", R.drawable.number_eighteen, R.drawable.eighteen_count),
        NumbersData("Nineteen", R.drawable.number_nineteen, R.drawable.nineteen_count),
        NumbersData("Twenty", R.drawable.number_twenty, R.drawable.twenty_count),
    )

    lateinit var numbersFragmentBinding: NumbersFragmentBinding
    private val numbersAdapter = NumbersAdapter(numberList, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        numbersFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.numbers_fragment, container, false)

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
        numberCountImage: Int
    ) {
        numbersFragmentBinding.theNumbersFragmentHeaderTextview.text = numberName
        numbersFragmentBinding.selectedNumberImageview.setImageResource(numberImage)
        numbersFragmentBinding.numberComparisonImageview.setImageResource(numberCountImage)

        when (numberName) {
            "One" -> {
                numbersFragmentBinding.numberDetailTextview.text =
                    "There is " + numberName + " finger."
            }
            "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" -> {
                numbersFragmentBinding.numberDetailTextview.text =
                    "There are " + numberName + " fingers."
            }
            "Eleven" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " Moanas."}

            "Twelve" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " pans."}

            "Thirteen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " strawberry donuts."}

            "Fourteen" -> {numbersFragmentBinding.numberDetailTextview.text =
            "There are " + numberName + " ladybugs."}

            "Fifteen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " chocolate donuts."}

            "Sixteen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " crowns."}
            "Seventeen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " candies."}
            "Eighteen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " Nemos."}
            "Nineteen" -> {numbersFragmentBinding.numberDetailTextview.text =
                "There are " + numberName + " pans."}

            "Twenty" -> {numbersFragmentBinding.numberDetailTextview.text =
            "There are " + numberName + " Grinches."}

        }
    }
}