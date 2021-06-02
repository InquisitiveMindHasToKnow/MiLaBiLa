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
                colorFragmentBinding.colorNameTextview.text = "Red"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FF0000"))
                textToSpeech.speak("Red", TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.blueButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#0000FF"))
                colorFragmentBinding.colorNameTextview.text = "Blue"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#0000FF"))
                textToSpeech.speak("Blue", TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.yellowButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFFF00"))
                colorFragmentBinding.colorNameTextview.text = "Yellow"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFFF00"))
                textToSpeech.speak("Yellow", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.purpleButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#800080"))
                colorFragmentBinding.colorNameTextview.text = "Purple"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#800080"))
                textToSpeech.speak("Purple", TextToSpeech.QUEUE_FLUSH, null)

            }

            colorFragmentBinding.greenButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#008000"))
                colorFragmentBinding.colorNameTextview.text = "Green"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#008000"))
                textToSpeech.speak("Green", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.orangeButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFA500"))
                colorFragmentBinding.colorNameTextview.text = "Orange"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFA500"))
                textToSpeech.speak("Orange", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.blackButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#000000"))
                colorFragmentBinding.colorNameTextview.setBackgroundColor(Color.parseColor("#FFFFFF"))
                colorFragmentBinding.colorNameTextview.text = "Black"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#000000"))
                textToSpeech.speak("Black", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.pinkButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFC0CB"))
                colorFragmentBinding.colorNameTextview.text = "Pink"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFC0CB"))
                textToSpeech.speak("Pink", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.brownButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#88540B"))
                colorFragmentBinding.colorNameTextview.text = "Brown"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#88540B"))
                textToSpeech.speak("Brown", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.grayButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#808080"))
                colorFragmentBinding.colorNameTextview.text = "Gray"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#808080"))
                textToSpeech.speak("Gray", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.whiteButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#FFFFFF"))
                colorFragmentBinding.colorNameTextview.setBackgroundColor(Color.parseColor("#000000"))
                colorFragmentBinding.colorNameTextview.text = "White"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#FFFFFF"))
                textToSpeech.speak("White", TextToSpeech.QUEUE_FLUSH, null)

            }
            colorFragmentBinding.maroonButton.id -> {
                colorFragmentBinding.colorFragConstraint.setBackgroundColor(Color.parseColor("#800000"))
                colorFragmentBinding.colorNameTextview.text = "Maroon"
                colorFragmentBinding.colorNameTextview.setTextColor(Color.parseColor("#800000"))
                textToSpeech.speak("Maroon", TextToSpeech.QUEUE_FLUSH, null)

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