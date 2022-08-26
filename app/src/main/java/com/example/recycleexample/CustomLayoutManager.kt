package com.example.recycleexample

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomLayoutManager(context:Context):LinearLayoutManager(context) {
    override fun setOrientation(orientation: Int) {
        println("Setting orientation")
        super.setOrientation(orientation)
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        println("Generating layout params")
        return super.generateDefaultLayoutParams()
    }

    override fun addView(child: View?) {
        super.addView(child)
        println("View added")
    }

    override fun layoutDecorated(child: View, left: Int, top: Int, right: Int, bottom: Int) {
        super.layoutDecorated(child, left, top, right, bottom)
        println("Layout is decorated")
    }

    override fun attachView(child: View) {
        super.attachView(child)
        println("View attached")
    }

    override fun onItemsAdded(recyclerView: RecyclerView, positionStart: Int, itemCount: Int) {
        super.onItemsAdded(recyclerView, positionStart, itemCount)
        println("Items adding..")
    }

    override fun onItemsRemoved(recyclerView: RecyclerView, positionStart: Int, itemCount: Int) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount)
        println("Removing...")
    }

    override fun removeView(child: View?) {
        super.removeView(child)
        println("Removed ${child?.id}")
    }

    override fun detachView(child: View) {
        super.detachView(child)
        println("view detached")
    }

    override fun findFirstVisibleItemPosition(): Int {
        println("Finding first visible element position")
        return super.findFirstVisibleItemPosition()
    }

    override fun detachAndScrapView(child: View, recycler: RecyclerView.Recycler) {
        super.detachAndScrapView(child, recycler)
        println("detached and scraped")
    }

    /*override fun getFocusedChild(): View? {
        println("${super.getFocusedChild()} is focused")
        return super.getFocusedChild()
    }*/

    override fun requestLayout() {
        println("requesting layout")
        super.requestLayout()
    }

    override fun stopIgnoringView(view: View) {
        println("Stop ignoring view")
        super.stopIgnoringView(view)
    }

    override fun scrollToPosition(position: Int) {
        println("scrolling to $position th position")
        super.scrollToPosition(position)
    }

    override fun endAnimation(view: View?) {
        println("Ending animation..")
        super.endAnimation(view)
    }

    override fun detachAndScrapAttachedViews(recycler: RecyclerView.Recycler) {
        println("detaching and scraping")
        super.detachAndScrapAttachedViews(recycler)
        println("detach and scrap -- done")

    }

    override fun findViewByPosition(position: Int): View? {
        println("Finding view at $position")
        return super.findViewByPosition(position)
    }
    /*override fun canScrollVertically(): Boolean {
        println("Scrollable vertically")
        return super.canScrollVertically()
    }*/
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        println("laying child.")
        super.onLayoutChildren(recycler, state)
    }

    override fun setRecycleChildrenOnDetach(recycleChildrenOnDetach: Boolean) {
        println("Recycle child on detach")
        super.setRecycleChildrenOnDetach(recycleChildrenOnDetach)
    }

    override fun removeAndRecycleAllViews(recycler: RecyclerView.Recycler) {
        println("remove recycle views")
        super.removeAndRecycleAllViews(recycler)
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        println("Layout completed")
    }

    override fun getItemViewType(view: View): Int {
        println("Getting item view type")
        return super.getItemViewType(view)
    }



}