package io.github.abhishekbhartiprojects.hindi_ted

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.abhishekbhartiprojects.hindi_ted.model.ItemTypes.EnglishWord
import kotlinx.android.synthetic.main.item_word_english.view.*

class SearchResultEnglishViewHolder(view : View): RecyclerView.ViewHolder(view) {

    fun bindView(englishWord: EnglishWord, searchResultViewModel: SearchResultViewModel){
        itemView.english_word_tv.text = englishWord.word
    }
}