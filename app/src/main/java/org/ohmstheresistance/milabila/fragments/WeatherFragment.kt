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
import org.ohmstheresistance.milabila.databinding.WeatherFragmentBinding
import org.ohmstheresistance.milabila.dataclasses.WeatherData
import org.ohmstheresistance.milabila.recyclerview.WeatherAdapter
import java.util.*

class WeatherFragment : Fragment(),WeatherAdapter.PassWeatherNameInterface,  TextToSpeech.OnInitListener {

    private val weatherList = listOf(
        WeatherData("Sunny", R.drawable.sunny, R.drawable.sun_icon),
        WeatherData("Rainy", R.drawable.raining, R.drawable.rain_icon),
        WeatherData("Cloudy", R.drawable.cloudy, R.drawable.cloud),
        WeatherData("Foggy", R.drawable.alt_foggy, R.drawable.fog_icon),
        WeatherData("Snowy", R.drawable.snowing, R.drawable.snow_icon),
        WeatherData("Windy", R.drawable.alt_windy, R.drawable.windy_icon),
        WeatherData("Lightning", R.drawable.lightning, R.drawable.lightning_icon),
        WeatherData("Tornado", R.drawable.tornado, R.drawable.tornado_icon)
    )

    private val weatherAdapter = WeatherAdapter(weatherList, this)
    lateinit var weatherFragmentBinding: WeatherFragmentBinding
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)

        textToSpeech = TextToSpeech(context, this)

        setupWeatherRecyclerView()

        return weatherFragmentBinding.root
    }

    private fun setupWeatherRecyclerView() {

        weatherFragmentBinding.weatherRecycler.layoutManager = GridLayoutManager(activity, 3)
        weatherFragmentBinding.weatherRecycler.adapter = weatherAdapter
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

    override fun passWeatherNameForTTS(clickedWeatherName: String) {
        var sentenceStartingPhrase = ""

         if(clickedWeatherName.equals("Sunny")||clickedWeatherName.equals("Windy")){

            sentenceStartingPhrase = "It is "

        } else {
            sentenceStartingPhrase = "This is a "
        }

        val sentenceToSay = sentenceStartingPhrase + clickedWeatherName
        textToSpeech.speak(sentenceToSay, TextToSpeech.QUEUE_FLUSH, null)
    }
}
