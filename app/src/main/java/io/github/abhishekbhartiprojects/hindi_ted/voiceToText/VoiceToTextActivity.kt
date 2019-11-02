package io.github.abhishekbhartiprojects.hindi_ted.voiceToText

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import io.github.abhishekbhartiprojects.hindi_ted.R
import java.util.*
import io.github.abhishekbhartiprojects.hindi_ted.SearchResultActivity
import kotlinx.android.synthetic.main.activity_voice_to_text.*


class VoiceToTextActivity : AppCompatActivity() {

    private var txtSpeechInput: TextView? = null
    private val REQ_CODE_SPEECH_INPUT = 100

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, VoiceToTextActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_to_text)

        initView()
        initClickListeners()

        txtSpeechInput = findViewById(R.id.txtSpeechInput) as TextView

        // hide the action bar
        if (actionBar != null) {
            actionBar!!.hide()
        }

    }

    private fun initView(){

    }

    private fun initClickListeners() {
        btnSpeak.setOnClickListener(View.OnClickListener { promptSpeechInput() })

        search_btn.setOnClickListener {
            if(txtSpeechInput != null && txtSpeechInput!!.text.isNotEmpty()){
                SearchResultActivity.start(this, txtSpeechInput!!.text.toString())
            } else {
                Toast.makeText(this, "No Query Found!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Showing google speech input dialog
     */
    private fun promptSpeechInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(
            RecognizerIntent.EXTRA_PROMPT,
            getString(io.github.abhishekbhartiprojects.hindi_ted.R.string.speech_prompt)
        )
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT)
        } catch (a: ActivityNotFoundException) {
            Toast.makeText(
                applicationContext,
                getString(io.github.abhishekbhartiprojects.hindi_ted.R.string.speech_not_supported),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    /**
     * Receiving speech input
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQ_CODE_SPEECH_INPUT -> {
                if (resultCode == Activity.RESULT_OK && null != data) {

                    val result = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    if(txtSpeechInput != null){
                        txtSpeechInput!!.text = result[0]
                        search_btn.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
