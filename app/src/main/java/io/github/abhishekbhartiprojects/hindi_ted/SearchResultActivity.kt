package io.github.abhishekbhartiprojects.hindi_ted

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultData
import io.github.abhishekbhartiprojects.hindi_ted.model.SearchResultResponse
import kotlinx.android.synthetic.main.activity_search_result.*


class SearchResultActivity : AppCompatActivity() {

    lateinit var searchResultViewModel: SearchResultViewModel
    lateinit var adapter: SearchResultAdapter
    lateinit var searchTerm: String
    var searchResultData: SearchResultData? = null

    companion object {
        val KEY_SEARCH_TERM: String = "KEY_SEARCH_TERM"

        fun start(context: Context, searchTerm: String = ""){
            val intent = Intent(context, SearchResultActivity::class.java)
            intent.putExtra(KEY_SEARCH_TERM, searchTerm)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        init()
        initBundle()
        setAllData()
        initUI()
    }

    private fun init() {
        initViews()
        initViewModel()
        initViewModelObserver()
        initClickListener()
    }

    private fun initBundle() {
        searchTerm = intent.getStringExtra(KEY_SEARCH_TERM)
    }

    private fun initUI(){
        if(!searchTerm.isEmpty()){
            search_query_et.setText(searchTerm)
            getSearchResult(searchTerm)
        }
    }

    private fun initViews() {
        search_result_list_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initViewModel() {
        searchResultViewModel = ViewModelProviders.of(this, SearchResultViewModelFactory())
            .get(SearchResultViewModel::class.java)
    }

    private fun initViewModelObserver() {
        searchResultViewModel.searchResultListData.observe(this, Observer {
            it?.let {
                if (it.size > 0) {
                    onSearchResultSuccess(it)
                } else {
                    Toast.makeText(this, "No Result Found!!", Toast.LENGTH_SHORT).show()
                }
            }
        })

        searchResultViewModel.searchResult.observe(this, Observer {
            it?.let {
                searchResultData = it
            }
        })
    }

    private fun initClickListener(){
        layout_hin_search_ll.setOnClickListener {
            if(!search_query_et.text.toString().isNullOrEmpty()){
                getSearchResult(search_query_et.text.toString())
            } else {
                Toast.makeText(this, "Enter search term!!", Toast.LENGTH_SHORT).show()
            }
        }

        dictionary_cv.setOnClickListener {
            if(searchResultData != null) {
                DictionaryActivity.start(this, searchResultData!!)
            }
        }
    }

    private fun onSearchResultSuccess(searchResultList: ArrayList<Any>) {
        if(searchResultList.size > 0){
            adapter = SearchResultAdapter(searchResultList, searchResultViewModel)
            search_result_list_rv.adapter = adapter
            dictionary_cv.visibility = View.VISIBLE
        } else {
            Toast.makeText(this, "No result found!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAllData(){
        searchResultViewModel.setAllData()
    }

    private fun getSearchResult(query: String){
        searchResultViewModel.getSearchResult(query)
    }

}
