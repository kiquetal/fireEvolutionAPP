package cresterida.me.learning.fireappevolution

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.SelectableAdapter
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.items.IFlexible
import kotlinx.android.synthetic.main.catalogue_main_controller.*

/**
 * Created by kiquetal on 1/1/18.
 */
import kotlinx.android.synthetic.main.catalogue_main_controller.recycler

class GuardFragment:AbstractFragment()
{

    lateinit var items:MutableList<IFlexible<*>>
    companion object {
        fun newInstance():GuardFragment= GuardFragment()
    }



    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater!!.inflate(R.menu.menu_holders, menu);
        Log.d("FireAppEvolution","CreateOptionsMenu" +
                "Guard")
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


        val g1:GuardHeader= GuardHeader("g1A");
        g1.title="Guardia 1A"
        g1.subtitle="BVC 307 David Noguera"
        val s1:GuardItem= GuardItem(g1.id + "s1")
        s1.title="BVC 351 Monserrat Arzamendia"
        s1.header=g1
        val s2:GuardItem= GuardItem(g1.id + "s2")
        s2.title="BVC 381 Hugo Aguero"
        s2.header=g1
        val s3:GuardItem= GuardItem(g1.id+"s3")
        s3.title="BVC 405 Kiquetal"
        s3.header=g1
        val s4:GuardItem= GuardItem(g1.id+"s4")
        s4.title="BVC 408 Letizia Cardozo"
        s4.header=g1
        g1.addSubItem(s1)
        g1.addSubItem(s2)
        g1.addSubItem(s3)
        g1.addSubItem(s4)


        val g2:GuardHeader= GuardHeader("g1B");
        g2.title="Guardia 1B"
        g2.subtitle="BVC 67 Javier Gomez"
        val s11:GuardItem= GuardItem(g2.id+"s11")
        s11.title="BVC 371 Blas López"
        s11.header=g2
        val s12:GuardItem= GuardItem(g2.id+"s12")
        s12.title="BVC 378 Guadalupe Aquino"
        s12.header=g2
        val s13:GuardItem= GuardItem(g2.id+"s13")
        s13.title="BVC 389 Miguel Navarro"
        s13.header=g2
        val s14:GuardItem= GuardItem(g2.id+"s14")
        s14.title="BVC 406 Yenni Santacruz"
        s14.header=g2
        g2.addSubItem(s11)
        g2.addSubItem(s12)
        g2.addSubItem(s13)
        g2.addSubItem(s14)



        items.add(g1)
        items.add(g2)
        val adapter=FlexibleAdapter(items)
                adapter.expandItemsAtStartUp()
                .setAutoCollapseOnExpand(false)
                .setAutoScrollOnExpand(true)
                .setAnimateToLimit(Integer.MAX_VALUE) //Size limit = MAX_VALUE will always animate the changes

        recycler.layoutManager = LinearLayoutManager(activity!!)
        recycler.adapter = adapter
        recycler.setHasFixedSize(true) //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        recycler.itemAnimator = DefaultItemAnimator()
        // Custom divider item decorator
        recycler.addItemDecoration(FlexibleItemDecoration(activity)
                .addItemViewType(R.layout.recycler_expandable_header_item)
                .withOffset(4))
        Log.v("FireApp","GuardFragment")
        mListener.onFragmentChange(null,recycler, SelectableAdapter.Mode.IDLE)

    }



}