package com.example.recycleexample

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchableActivity : AppCompatActivity() {
    private lateinit var recycle: RecyclerView
    private lateinit var adapter:ListAdapter
    private lateinit var manager: LinearLayoutManager

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.example_menu,menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView=menu?.findItem(R.id.search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return true
        //return super.onCreateOptionsMenu(menu)
    }*/

    val list= mutableListOf("Apple","Ball","Cat","Dog","Elephant","Fish","Gun","Hat","Ice cream","Jug","Kite","Lion","Orange","Peacock","Queue","Rat","Snake","Table","Unicorn","Van","Watch","X-Ray","Yam","Zebra")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Verify the action and get the query
        recycle=findViewById(R.id.re)
        var x= DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycle.addItemDecoration(x);
        recycle.setHasFixedSize(true)
        manager=LinearLayoutManager(this)
        //manager.orientation=LinearLayoutManager.HORIZONTAL
        adapter=ListAdapter()
        //adapter.setData(list)
        recycle.layoutManager=manager
        recycle.adapter=adapter
        adapter.setOnItemClickListener(object:ListAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                println("$position is clicked")
            }

        })

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                supportActionBar?.title="Search Results"
                doMySearch(query)
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun doMySearch(query: String) {
        val newList= mutableListOf<String>()
        for(i in list){
            if(i.lowercase().contains(query.lowercase())){
                newList.add(i)
            }
        }
        adapter.setData(newList)
    }
}