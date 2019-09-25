package io.github.abhishekbhartiprojects.hindi_ted

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultData
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import kotlinx.android.synthetic.main.activity_dictionary.*

class DictionaryActivity : AppCompatActivity() {

    var searchResultData: SearchResultData? = null

    companion object {
        val KEY_SEARCH_RESULT_DATA = "SEARCH_RESULT_DATA"

        fun start(context: Context, searchResultData: SearchResultData){
            val intent = Intent(context, DictionaryActivity::class.java)
            intent.putExtra(KEY_SEARCH_RESULT_DATA, searchResultData)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        initBundle()
        init()
    }

    private fun initBundle(){
        searchResultData = intent.getParcelableExtra(KEY_SEARCH_RESULT_DATA)
    }

    private fun init(){
        if(searchResultData != null){
            if(searchResultData!!.levels.size > 0) {
                hindi_word_tv.text = searchResultData!!.levels[0].word
            }

            dictionary_text_tv.text = searchResultData!!.dictionary
            dictionary_text_tv.visibility = View.VISIBLE

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
