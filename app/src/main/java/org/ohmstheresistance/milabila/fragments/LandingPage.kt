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
import org.ohmstheresistance.milabila.dataclasses.LandingPageButtonsData
import org.ohmstheresistance.milabila.recyclerview.LandingPageButtonsAdapter

class LandingPage : Fragment() {

private lateinit var landingPageBinding: LandingPageFragmentBinding

private val buttonNameList = listOf(
    LandingPageButtonsData("Alphabet"),
    LandingPageButtonsData("Numbers"),
    LandingPageButtonsData("Weather"),
    LandingPageButtonsData("Colors"),
    LandingPageButtonsData("Shapes"),
    LandingPageButtonsData("Days\nAnd\nMonths"))

    private val landingPageButtonsAdapter = LandingPageButtonsAdapter(buttonNameList)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        landingPageBinding = DataBindingUtil.inflate(inflater, R.layout.landing_page_fragment, container, false)

        setupLandingPageButtons()

        return landingPageBinding.root
    }

    private fun setupLandingPageButtons(){
        landingPageBinding.landingPageButtonListRecycler.layoutManager = GridLayoutManager(context, 3)
        landingPageBinding.landingPageButtonListRecycler.adapter = landingPageButtonsAdapter
    }
}