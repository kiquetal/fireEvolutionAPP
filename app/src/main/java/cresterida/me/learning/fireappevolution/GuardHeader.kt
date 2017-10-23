package cresterida.me.learning.fireappevolution

import android.graphics.Typeface
import android.os.Build
import android.support.annotation.RequiresApi
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * Created by kiquetal on 10/22/17.
 */
import kotlinx.android.synthetic.main.catalogue_main_controller_card.view.*;
data class GuardHeader(val name:String): AbstractHeaderItem<GuardHeader.Holder>(){
    override fun getLayoutRes(): Int {
        return R.layout.catalogue_main_controller_card
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: Holder?, position: Int, payloads: MutableList<Any?>?) {

        holder!!.bind(this)


    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): Holder {

        return Holder(view!!,adapter!!)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return name == (other as GuardHeader).name
    }


    class Holder(view: View, adapter: FlexibleAdapter<*>): FlexibleViewHolder(view,adapter,false)
    {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(guard:GuardHeader):Unit {

            itemView.title.text= guard.name

        }
    }

}