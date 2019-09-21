package io.github.abhishekbhartiprojects.hindi_ted

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context

class SearchResultViewModelFactory(): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return SearchResultViewModel() as T
    }
}