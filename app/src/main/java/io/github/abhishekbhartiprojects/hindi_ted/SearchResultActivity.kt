package io.github.abhishekbhartiprojects.hindi_ted

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_result.*
import org.json.JSONObject
import org.json.JSONException
import org.json.JSONArray


class SearchResultActivity : AppCompatActivity() {

    lateinit var searchResultViewModel: SearchResultViewModel
    lateinit var adapter: SearchResultAdapter

    companion object {
        fun start(context: Context){
            val intent = Intent(context, SearchResultActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        init()
    }

    private fun init() {
        initViews()
        initViewModel()
        initViewModelObserver()
        getDefaultSearchResult()
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
        searchResultViewModel.searchResult.observe(this, Observer {
            it?.let {
                if (it.size > 0) {
                    onSearchResultSuccess(it)
                }
            }
        })
    }

    private fun onSearchResultSuccess(searchResultList: ArrayList<Any>) {
        adapter = SearchResultAdapter(searchResultList, searchResultViewModel)
        search_result_list_rv.adapter = adapter
    }

    private fun getDefaultSearchResult(){
        searchResultViewModel.getSearchResult("")
    }

//    private fun downloadSpreadsheetData(){
//        DownloadWebpageTask(AsyncResult { `object` -> processJson(`object`) }).execute("https://spreadsheets.google.com/tq?key=1yyTcjWA6RAUwkI7sKOevWXAJfpITs__Zb0TwilihDCw")
//    }
//
//    var teams = ArrayList<Team>()
//    private fun processJson(`object`: JSONObject) {
//
//        try {
//            val rows = `object`.getJSONArray("rows")
//
//            for (r in 0 until rows.length()) {
//                val row = rows.getJSONObject(r)
//                val columns = row.getJSONArray("c")
//
//                val position = columns.getJSONObject(0).getInt("v")
//                val name = columns.getJSONObject(1).getString("v")
//                val wins = columns.getJSONObject(3).getInt("v")
//                val draws = columns.getJSONObject(4).getInt("v")
//                val losses = columns.getJSONObject(5).getInt("v")
//                val points = columns.getJSONObject(19).getInt("v")
//                val team = Team(position, name, wins, draws, losses, points)
//                teams.add(team)
//            }
//
//            val adapter = TeamsAdapter(this, R.layout.team, teams)
//            listview.setAdapter(adapter)
//
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//    }
}
