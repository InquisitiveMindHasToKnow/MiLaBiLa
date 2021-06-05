package org.ohmstheresistance.milabila.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.WeatherFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.WeatherData
import org.ohmstheresistance.milabila.recyclerview.WeatherAdapter

class WeatherFragment : Fragment() {

    private val weatherList = listOf(
        WeatherData("Sunny", R.drawable.sunny, R.drawable.sun_icon),
        WeatherData("Rainy", R.drawable.raining, R.drawable.rain_icon),
        WeatherData("Cloudy", R.drawable.cloudy, R.drawable.cloud),
        WeatherData("Foggy", R.drawable.alt_foggy, R.drawable.fog_icon),
        WeatherData("Snowy", R.drawable.snowing, R.drawable.snow_icon),
        WeatherData("Windy", R.drawable.alt_windy, R.drawable.windy_icon)
    )
    private val weatherAdapter = WeatherAdapter(weatherList, this)
    lateinit var weatherFragmentBinding: WeatherFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)

        setupWeatherRecyclerView()

        return weatherFragmentBinding.root
    }

    private fun setupWeatherRecyclerView() {

        weatherFragmentBinding.weatherRecycler.layoutManager = GridLayoutManager(context, 3)
        weatherFragmentBinding.weatherRecycler.adapter = weatherAdapter
    }
}
