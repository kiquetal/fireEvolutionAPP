package cresterida.me.learning.fireappevolution

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
 import eu.davidea.flexibleadapter.SelectableAdapter.Mode;

import android.view.Menu
import android.view.MenuInflater
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.IFlexible

import kotlinx.android.synthetic.main.catalogue_main_controller.recycler
/**
 * Created by kiquetal on 10/8/17.
 */
class HolderFragment: AbstractFragment(){

   lateinit var items:MutableList<IFlexible<*>>
    companion object {
        fun newInstance(): HolderFragment=HolderFragment()
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.menu_holders, menu);
        Log.d("FireAppEvolution","CreateOptionsMenu" +
                "")
        mListener.initSearchView(menu!!)
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState!=null)
        {
            Log.d("FireAppEvolution","create new instance with the list");
        }
        items= mutableListOf()
        var header= CodeHeader("CODIGO INFORMACION")
        var item= CodeItem("Kiquetal",header)
        var item2= CodeItem("Kiquetal2",header)
        var item3= CodeItem("Kiquetal3",header)
        var header2= CodeHeader("2A")
        var item21= CodeItem("Kiquetal21",header2)
        var item22= CodeItem("Kiquetal22",header2)
        var item23= CodeItem("Kiquetal23",header2)
        var header3= CodeHeader("3A")
        var item31= CodeItem("Flo",header3)
        var item32= CodeItem("Kiquetal32",header3)
        var item33= CodeItem("Kiquetal33",header3)

        items.add(item)
        items.add(item2)
        items.add(item3)
        items.add(item21)
        items.add(item22)
        items.add(item23)
        items.add(item31)
        items.add(item32)
        items.add(item33)
        val adapter=FlexibleAdapter(items)
        adapter.setDisplayHeadersAtStartUp(true).setStickyHeaders(true).setOnlyEntryAnimation(true)

        recycler.layoutManager =LinearLayoutManager(activity!!)
        recycler.adapter=adapter
        recycler.setHasFixedSize(true)
        mListener.onFragmentChange(null,recycler,Mode.IDLE)
        Log.v("FireApp","Holderragment")
    }
}


