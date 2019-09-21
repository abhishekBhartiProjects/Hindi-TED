package io.github.abhishekbhartiprojects.hindi_ted

import io.github.abhishekbhartiprojects.hindi_ted.model.ItemTypes.EnglishWord
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import io.reactivex.Single

class SearchResultRepository {

    fun getSearchResult(query: String): Single<ArrayList<Any>>{
        val dummyResponse = DummyResponse()
        return dummyResponse.getDummyResponse(dummyResponse.response).map {
            processData(it)
        }
    }

    private fun processData(searchResultResponse: SearchResultResponse): ArrayList<Any>{
        val processedSearchResult : ArrayList<Any> = arrayListOf()
        if(searchResultResponse.data != null){

            processedSearchResult.addAll(searchResultResponse.data!!.levels)

            val englishWord = EnglishWord()
            englishWord.word = searchResultResponse.data!!.english_word
            processedSearchResult.add(englishWord)
        }

        return processedSearchResult
    }
}