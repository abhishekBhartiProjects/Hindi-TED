package io.github.abhishekbhartiprojects.hindi_ted

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchResultViewModel: ViewModel() {
    var repository: SearchResultRepository = SearchResultRepository()

    var searchResult: MutableLiveData<ArrayList<Any>> = MutableLiveData()

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
        searchResult.value = searchResultList
    }

    private fun onGetSearchResultError(throwable: Throwable){

    }

}