package com.example.recycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recycle:RecyclerView
    private lateinit var adapter:ListAdapter
    private lateinit var manager:LinearLayoutManager
    private var list:MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list= mutableListOf("Apple","Ball","Cat","Dog","Elephant","Fish","Gun","Hat","Ice cream","Jug","Kite","Lion","Orange","Peacock","Queue","Rat","Snake","Table","Unicorn","Van","Watch","X-Ray","Yam","Zebra")
        recycle=findViewById(R.id.recycleView)
        var x=DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycle.addItemDecoration(x);
        recycle.setHasFixedSize(true)
        manager=LinearLayoutManager(this)
        //manager.orientation=LinearLayoutManager.HORIZONTAL
        adapter=ListAdapter()
        adapter.setData(list)
        recycle.layoutManager=manager
        recycle.adapter=adapter
        adapter.setOnItemClickListener(object:ListAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                println("$position is clicked")
            }

        })
        //recycle.smoothScrollBy(100,100)
        //recycle.scrollToPosition(10)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.example_menu,menu)
        val searchView=menu?.findItem(R.id.search)?.actionView as SearchView
       // val searchView=menu.fin
        //searchView.queryHint="Search movie..."

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val sublist:MutableList<String> = mutableListOf()
                for(a in list) {
                    if (a.lowercase().contains(newText.toString().lowercase())) {
                        sublist.add(a)
                    }
                }
                adapter.setData(sublist)
                adapter.notifyDataSetChanged()
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_first->{
                adapter.insertFirstItem()
                return true
            }
            R.id.add_last->{
                adapter.insertLastItem()
                return true
            }
            R.id.delete_first->{
                adapter.removeFirstItem()
                return true
            }
            R.id.delete_last->{
                adapter.removeLastItem()
                return true
            }
            R.id.delete_first_five->{
                adapter.removeFirstFive()
                return true
            }
            R.id.add_five_items->{
                adapter.addFiveItems()
                return true
            }
            else-> return super.onOptionsItemSelected(item)
        }
    }
}

