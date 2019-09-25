package io.github.abhishekbhartiprojects.hindi_ted.model

import android.os.Parcelable
import android.support.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
class WordLevel (
    var level: Int = -1,
    var word: String = "",
    var example: String = "",
    var word_type: String = ""
): Parcelable