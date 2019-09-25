package io.github.abhishekbhartiprojects.hindi_ted

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.abhishekbhartiprojects.hindi_ted.model.ItemTypes.EnglishWord
import io.github.abhishekbhartiprojects.hindi_ted.model.WordLevel

class SearchResultAdapter(var searchResultList: ArrayList<Any>, var searchResultViewModel: SearchResultViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return searchResultList.size
    }

    override fun getItemViewType(position: Int): Int {
        var itemViewType: Int = -1

        when (searchResultList[position]) {
            is WordLevel -> {
                return R.layout.item_word_level
            }
            is EnglishWord -> {
                return R.layout.item_word_english
            }
        }

        return itemViewType
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        val viewHolder: RecyclerView.ViewHolder
        when (viewType) {
            R.layout.item_word_level -> {
                view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_word_level, viewGroup, false)
                viewHolder = SearchResultLevelViewHolder(view)
            }
            R.layout.item_word_english -> {
                view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_word_english, viewGroup, false)
                viewHolder = SearchResultEnglishViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_word_english, viewGroup, false)
                viewHolder = SearchResultEnglishViewHolder(view)
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SearchResultLevelViewHolder -> holder.bindView(searchResultList[position] as WordLevel, searchResultViewModel)

            is SearchResultEnglishViewHolder -> {
                holder.bindView(searchResultList[position] as EnglishWord, searchResultViewModel)
            }
        }
    }


}