package cresterida.me.learning.fireappevolution
import android.util.Log
import android.view.View
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractSectionableItem
import eu.davidea.flexibleadapter.items.IFilterable
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.utils.FlexibleUtils
import eu.davidea.viewholders.FlexibleViewHolder
/**
 * Created by kiquetal on 10/22/17.
 */
import kotlinx.android.synthetic.main.catalogue_main_controller_card_item.view.*


data class GuardItem(val value:String, val header:GuardHeader): AbstractSectionableItem<GuardItem.ViewHolder, GuardHeader>(header),IFilterable
{
    override fun filter(constraint: String?): Boolean {
        return this.value.toLowerCase().trim().contains(constraint!!) || this.getHeader().name.toLowerCase().trim().contains(constraint!!)

    }

    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return value == (other as GuardItem).value

    }
    override fun getLayoutRes()=R.layout.catalogue_main_controller_card_item

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?): ViewHolder {

        return ViewHolder(view!!,adapter!!)
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<out IFlexible<*>>?, holder: ViewHolder?, position: Int, payloads: MutableList<Any?>?) {

        holder!!.bind(this)
    }


    class ViewHolder(view: View, adapter: FlexibleAdapter<*>): FlexibleViewHolder(view,adapter)
    {

        fun bind(guardItem:GuardItem):Unit
        {
            itemView.title.text=guardItem.value


            itemView.setOnClickListener(View.OnClickListener { view: View? -> Log.v("FireApp",itemView.title.text.toString()) })
            FlexibleUtils.highlightText(itemView.title, guardItem.value, this@ViewHolder.mAdapter.searchText);
      //      FlexibleUtils.highlightWords(guardItem.header.name, getSubtitle(), adapter.getSearchText());



        }


    }

}

