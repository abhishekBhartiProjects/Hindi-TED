package io.github.abhishekbhartiprojects.hindi_ted.model

import android.os.Parcelable
import android.support.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class SearchResultData (
    var hindi_word: String = "",
    var search_term: String = "",
    var dictionary: String = "",
    val levels: ArrayList<WordLevel> = arrayListOf(),
    var english_word: String = ""
    ): Parcelable