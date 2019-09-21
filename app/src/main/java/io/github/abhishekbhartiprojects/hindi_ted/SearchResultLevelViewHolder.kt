package io.github.abhishekbhartiprojects.hindi_ted

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import io.github.abhishekbhartiprojects.hindi_ted.model.WordLevel

class SearchResultLevelViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindView(level: WordLevel, searchResultViewModel: SearchResultViewModel){
        Log.e("SRLVH", "BindView Called")
    }

}