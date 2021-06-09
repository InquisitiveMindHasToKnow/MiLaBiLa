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
        WeatherData("Sun", R.drawable.sunny, R.drawable.sun_icon),
        WeatherData("Rain", R.drawable.raining, R.drawable.rain_icon),
        WeatherData("Cloud", R.drawable.cloudy, R.drawable.cloud),
        WeatherData("Fog", R.drawable.alt_foggy, R.drawable.fog_icon),
        WeatherData("Snow", R.drawable.snowing, R.drawable.snow_icon),
        WeatherData("Wind", R.drawable.alt_windy, R.drawable.windy_icon),
        WeatherData("Lightning", R.drawable.lightning, R.drawable.lightning_icon),
        WeatherData("Tornado", R.drawable.tornado, R.drawable.tornado_icon),
        WeatherData("Rainbow", R.drawable.rainbow, R.drawable.rainbow_icon))

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

        var sentenceToSay = ""

        when(clickedWeatherName) {
            "Sun" -> sentenceToSay = resources.getString(R.string.sunny)
            "Rain" -> sentenceToSay = resources.getString(R.string.raining)
            "Wind" -> sentenceToSay = resources.getString(R.string.windy)
            "Cloud" -> sentenceToSay = resources.getString(R.string.cloudy)
            "Fog" -> sentenceToSay = resources.getString(R.string.foggy)
            "Snow" -> sentenceToSay = resources.getString(R.string.snowing)
            "Tornado" -> sentenceToSay = resources.getString(R.string.tornado)
            "Lightning" -> sentenceToSay = resources.getString(R.string.lightning)
            "Rainbow" -> sentenceToSay = resources.getString(R.string.rainbow)
        }

        textToSpeech.speak(sentenceToSay, TextToSpeech.QUEUE_FLUSH, null)
    }
}
