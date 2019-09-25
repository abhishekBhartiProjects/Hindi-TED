package io.github.abhishekbhartiprojects.hindi_ted.model

import android.support.annotation.Keep
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class SearchResultResponse (
    var success: Boolean = false,
    var data: ArrayList<SearchResultData> = arrayListOf(),
    var message: String = ""
): Parcelable