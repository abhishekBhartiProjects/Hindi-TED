package io.github.abhishekbhartiprojects.hindi_ted

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.abhishekbhartiprojects.hindi_ted.voiceToText.VoiceToTextActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClickListener()
    }

    private fun initClickListener(){
        layout_hin_search_ll.setOnClickListener {
            SearchResultActivity.start(this)
        }

        layout_hin_eng_ll.setOnClickListener {
            VoiceToTextActivity.Companion.start(this)
        }
    }
}
