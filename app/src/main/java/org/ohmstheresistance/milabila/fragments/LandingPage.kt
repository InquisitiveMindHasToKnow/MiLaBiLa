package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.LandingPageFragmentBinding

class LandingPage : Fragment() {

lateinit var landingPageBinding: LandingPageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        landingPageBinding = DataBindingUtil.inflate(inflater, R.layout.landing_page_fragment, container, false)

        goToDesiredPage()

        return landingPageBinding.root
    }

    private fun goToDesiredPage(){

        landingPageBinding.landingPageAlphabetButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_alphabetFragment))
        landingPageBinding.landingPageNumbersButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_numbersFragment))
        landingPageBinding.landingPageColorsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_colorFragment))
        landingPageBinding.landingPageShapesButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_shapesFragment))
        landingPageBinding.landingPageWeatherButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_weatherFragment))
        landingPageBinding.landingPageDaysAndMonthsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_landingPage_to_daysAndMonthsFragment22))
    }
}