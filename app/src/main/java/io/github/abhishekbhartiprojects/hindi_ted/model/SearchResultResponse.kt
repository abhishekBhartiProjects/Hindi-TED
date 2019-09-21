package io.github.abhishekbhartiprojects.hindi_ted.model

import android.support.annotation.Keep

@Keep
class SearchResultResponse {
    var success: Boolean = false
    var data: SearchResultData? = null
    var message: String = ""
}