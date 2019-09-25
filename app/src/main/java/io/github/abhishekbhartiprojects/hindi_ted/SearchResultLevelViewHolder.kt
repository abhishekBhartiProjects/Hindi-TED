package io.github.abhishekbhartiprojects.hindi_ted

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import io.github.abhishekbhartiprojects.hindi_ted.model.WordLevel
import kotlinx.android.synthetic.main.item_word_level.view.*

class SearchResultLevelViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindView(level: WordLevel, searchResultViewModel: SearchResultViewModel){
        itemView.example_list_ll.visibility = View.GONE
        itemView.level_no_tv.text = "0"+level.level
        itemView.hindi_word_tv.text = level.word
        itemView.example1_text_tv.text = level.example
//        itemView.example2_text_tv.text = level.example
        itemView.toggle_example_iv.setOnClickListener {
            toggleExample()
        }
    }

    private fun toggleExample(){
        if(itemView.example_list_ll != null){
            if(itemView.example_list_ll.visibility == View.VISIBLE){
                itemView.example_list_ll.visibility = View.GONE
            } else {
                itemView.example_list_ll.visibility = View.VISIBLE
            }
        }
    }

}