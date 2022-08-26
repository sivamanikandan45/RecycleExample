package com.example.recycleexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter() : RecyclerView.Adapter<com.example.recycleexample.ListAdapter.ViewHolder>(){
    //var count:Int=0
    private var list:MutableList<String> = mutableListOf()
    private lateinit var listener:ItemClickListener

    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:ItemClickListener){
        this.listener=listener
    }

    class ViewHolder(view: View,listener: ItemClickListener):RecyclerView.ViewHolder(view){
        val text:TextView
        init {
            text=view.findViewById(R.id.text)
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        return position%2*2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //println("creating viewHolder ${++count}\nGot viewType $viewType")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view,listener)

        /*when(viewType){
            0->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                return ViewHolder(view)
            }
            2->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_new_item, parent, false)
                return ViewHolder(view)
            }
        }*/

        /*return if(viewType==0){ val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            ViewHolder(view)}else {val view = LayoutInflater.from(parent.context).inflate(R.layout.list_new_item, parent, false)
            ViewHolder(view)}*/

    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        println("Binding viewHolder")
        holder.text.text = list[position]
    }

    override fun getItemCount(): Int {
        //println("Getting count")
        return list.size
    }
    //56-84
    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        println("view recycled")
    }

    override fun getItemId(position: Int): Long {
        println("Getting Item id")
        return super.getItemId(position)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        println("View detached from window")
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        println("View attached to Window")
    }

    override fun onFailedToRecycleView(holder: ViewHolder): Boolean {
        println("Failed to recycle the view")
        return super.onFailedToRecycleView(holder)
    }

    override fun registerAdapterDataObserver(observer: RecyclerView.AdapterDataObserver) {
        println("Register")
        super.registerAdapterDataObserver(observer)
    }

    fun removeFirstItem(){
        list.removeAt(0)
        notifyItemRemoved(0)
        //super.notifyDataSetChanged()
    }

    fun removeLastItem(){
        list.removeAt(list.size-1)
        notifyItemRemoved(list.size-1)
    }

    fun insertFirstItem(){
        list.add(0,"New")
        notifyItemInserted(0)
    }

    fun insertLastItem(){
        list.add(list.size,"New")
        notifyItemInserted(list.size)
    }

    fun removeFirstFive(){
        for(i in 1..5){
            list.removeAt(0)
        }
        notifyItemRangeRemoved(0,5)
    }

    fun addFiveItems(){
        for(i in 1..5){
            list.add(0,"New")
        }
        notifyItemRangeInserted(0,5)
    }

    fun setData(list: MutableList<String>) {
        this.list=list
    }

}
