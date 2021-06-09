package org.ohmstheresistance.milabila.fragments

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.milabila.R
import org.ohmstheresistance.milabila.databinding.ColorFragmentBinding
import java.util.*

class ColorFragment : Fragment(), View.OnClickListener, TextToSpeech.OnInitListener {

    lateinit var colorFragmentBinding: ColorFragmentBinding
    lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        colorFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.color_fragment, container, false)

        textToSpeech = TextToSpeech(context, this)


        setUpButtonClickListeners()


        return colorFragmentBinding.root

    }

    override fun onClick(view: View?) {

        when (view?.id) {
            colorFragmentBinding.redButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FF0000"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.red)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FF0000"))
                textToSpeech.speak(resources.getString(R.string.red), TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.blueButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#0000FF"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.blue)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#0000FF"))
                textToSpeech.speak(resources.getString(R.string.blue), TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.yellowButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFFF00"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.yellow)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFFF00"))
                textToSpeech.speak(resources.getString(R.string.yellow), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.purpleButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#800080"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.purple)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#800080"))
                textToSpeech.speak(resources.getString(R.string.purple), TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.greenButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#008000"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.green)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#008000"))
                textToSpeech.speak(resources.getString(R.string.green), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.orangeButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFA500"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.orange)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFA500"))
                textToSpeech.speak(resources.getString(R.string.orange), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.blackButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#000000"))
                colorFragmentBinding.colorNameTextview.setBackgroundColor(Color.parseColor("#FFFFFF"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.black)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#000000"))
                textToSpeech.speak(resources.getString(R.string.black), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.pinkButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFC0CB"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.pink)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFC0CB"))
                textToSpeech.speak(resources.getString(R.string.pink), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.brownButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#88540B"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.brown)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#88540B"))
                textToSpeech.speak(resources.getString(R.string.brown), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.grayButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#808080"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.gray)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#808080"))
                textToSpeech.speak(resources.getString(R.string.gray), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.whiteButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFFFFF"))
                colorFragmentBinding.colorNameTextview.setBackgroundColor(Color.parseColor("#000000"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.white)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFFFFF"))
                textToSpeech.speak(resources.getString(R.string.white), TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.maroonButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#800000"))
                colorFragmentBinding.colorNameTextview.text = resources.getString(R.string.maroon)
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#800000"))
                textToSpeech.speak(resources.getString(R.string.maroon), TextToSpeech.QUEUE_FLUSH, null)

            }

            else -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFFFFF"))

            }

        }
    }

    private fun setUpButtonClickListeners() {
        colorFragmentBinding.redButton.setOnClickListener(this)
        colorFragmentBinding.blueButton.setOnClickListener(this)
        colorFragmentBinding.yellowButton.setOnClickListener(this)
        colorFragmentBinding.purpleButton.setOnClickListener(this)
        colorFragmentBinding.greenButton.setOnClickListener(this)
        colorFragmentBinding.orangeButton.setOnClickListener(this)
        colorFragmentBinding.blackButton.setOnClickListener(this)
        colorFragmentBinding.pinkButton.setOnClickListener(this)
        colorFragmentBinding.brownButton.setOnClickListener(this)
        colorFragmentBinding.grayButton.setOnClickListener(this)
        colorFragmentBinding.whiteButton.setOnClickListener(this)
        colorFragmentBinding.maroonButton.setOnClickListener(this)
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
}