package org.ohmstheresistance.milabila.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.dataclasses.WeatherData
import org.ohmstheresistance.milabila.fragments.WeatherFragment

class WeatherAdapter(private val weatherList: List<WeatherData>, private val weatherFragment: WeatherFragment) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_itemview, parent, false)


        return WeatherViewHolder(v)
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindItems(weatherList[position])

        val weatherTypeClicked = weatherList[position].weatherName
        val weatherTypeToDisplay = weatherList[position].weatherTypeImage

        holder.itemView.setOnClickListener {

            Glide.with(it)
                .load(weatherTypeToDisplay)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(weatherFragment.weatherFragmentBinding.weatherImageview)

            weatherFragment.weatherFragmentBinding.weatherTypeTextview.text = weatherTypeClicked

            weatherFragment.passWeatherNameForTTS(weatherTypeClicked)
        }
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(weatherData: WeatherData) {
            val letterImage: ImageView = itemView.findViewById(R.id.weather_type_itemview_imageview) as ImageView
            letterImage.setImageResource(weatherData.weatherTypeButtonImage)

            val weather = weatherData.weatherName
            val weatherName: TextView = itemView.findViewById(R.id.weather_type_textview)
            weatherName.text = weather
        }
    }
    interface PassWeatherNameInterface {
        fun passWeatherNameForTTS(clickedWeatherName: String)
    }
}
