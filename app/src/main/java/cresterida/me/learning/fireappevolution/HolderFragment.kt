package cresterida.me.learning.fireappevolution

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible
import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.fragment_recycler.view.*

import kotlinx.android.synthetic.main.catalogue_main_controller.recycler
/**
 * Created by kiquetal on 10/8/17.
 */
class HolderFragment: AbstractFragment(){

   lateinit var items:MutableList<IFlexible<*>>
    companion object {
        fun newInstance(): HolderFragment=HolderFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState!=null)
        {
            Log.d("FireAppEvolution","create new instance with the list");
        }
        items= mutableListOf()
        var header=GuardHeader("1A")
        var item=GuardItem("Kiquetal",header)
        var item2=GuardItem("Kiquetal2",header)
        var item3=GuardItem("Kiquetal3",header)
        var header2=GuardHeader("2A")
        var item21=GuardItem("Kiquetal21",header2)
        var item22=GuardItem("Kiquetal22",header2)
        var item23=GuardItem("Kiquetal23",header2)
        items.add(item)
        items.add(item2)
        items.add(item3)
        items.add(item21)
        items.add(item22)
        items.add(item23)
        val adapter=FlexibleAdapter(items)
        adapter.setDisplayHeadersAtStartUp(true)
        recycler.layoutManager =LinearLayoutManager(activity)
        recycler.adapter=adapter

        Log.d("FireAppEvolution","MiFragment")
    }
}


