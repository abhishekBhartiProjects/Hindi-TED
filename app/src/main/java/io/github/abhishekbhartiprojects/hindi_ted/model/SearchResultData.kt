package io.github.abhishekbhartiprojects.hindi_ted.model

import android.support.annotation.Keep

@Keep
class SearchResultData {
    var hindi_word: String = ""
    val levels: ArrayList<WordLevel> = arrayListOf()
    var english_word: String = ""
}