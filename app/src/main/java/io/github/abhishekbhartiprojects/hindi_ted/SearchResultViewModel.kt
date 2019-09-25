package io.github.abhishekbhartiprojects.hindi_ted

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultData
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchResultViewModel: ViewModel() {
    var repository: SearchResultRepository = SearchResultRepository()

    var searchResultListData: MutableLiveData<ArrayList<Any>> = MutableLiveData()
    var searchResult: MutableLiveData<SearchResultData> = MutableLiveData()

    fun setAllData(){
        repository.setAllData()
    }

    @SuppressLint("CheckResult")
    fun getSearchResult(query: String){
        repository.getSearchResult(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onGetSearchResultSuccess(it)
            },{
                onGetSearchResultError(it)
            })
    }

    private fun onGetSearchResultSuccess(searchResultList: ArrayList<Any>) {
        searchResultListData.value = searchResultList
        searchResult.value = repository.searchResultData
    }

    private fun onGetSearchResultError(throwable: Throwable){

    }

}