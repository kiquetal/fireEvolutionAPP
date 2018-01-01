package cresterida.me.learning.fireappevolution

import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import eu.davidea.flexibleadapter.items.IFlexible

/**
 * Created by kiquetal on 1/1/18.
 */
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
                "")
        mListener.initSearchView(menu!!)
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
    }



}