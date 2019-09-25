package io.github.abhishekbhartiprojects.hindi_ted

import io.github.abhishekbhartiprojects.hindi_ted.model.ItemTypes.EnglishWord
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultData
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import io.reactivex.Single

class SearchResultRepository {

    var searchResultResponse: Single<SearchResultResponse>? = null
    var searchResultData: SearchResultData? = null

    fun setAllData(){
        val dummyResponse = DummyResponse()
        searchResultResponse =  dummyResponse.getDummyResponse(dummyResponse.response)
    }

    fun getSearchResult(query: String): Single<ArrayList<Any>> {

        if(searchResultResponse == null) {
            val dummyResponse = DummyResponse()
            searchResultResponse = dummyResponse.getDummyResponse(dummyResponse.response)

            return dummyResponse.getDummyResponse(dummyResponse.response).map {
                processData(it, query)
            }
        } else {
            return searchResultResponse!!.map {
                processData(it, query)
            }
        }

    }

    private fun processData(
        searchResultResponse: SearchResultResponse,
        query: String
    ): ArrayList<Any> {
        val processedSearchResult: ArrayList<Any> = arrayListOf()
        if (searchResultResponse.data.size > 0) {

            val searchResultData: SearchResultData? = filterData(searchResultResponse.data, query)

            if(searchResultData != null){
                this.searchResultData = searchResultData
                processedSearchResult.addAll(searchResultData!!.levels)

                val englishWord = EnglishWord()
                englishWord.word = searchResultData!!.english_word
                processedSearchResult.add(englishWord)
            }
        }

        return processedSearchResult
    }

    private fun filterData(allData: ArrayList<SearchResultData>, query: String): SearchResultData? {
        val searchResultData : SearchResultData? = null
        for (searchData in allData){
            if(searchData.search_term.contains(query, false)){
                return searchData
            }
        }

        return searchResultData
    }
}