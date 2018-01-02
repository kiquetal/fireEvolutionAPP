package cresterida.me.learning.fireappevolution

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.Payload
import eu.davidea.flexibleadapter.items.IExpandable
import eu.davidea.flexibleadapter.items.IHeader
import eu.davidea.viewholders.ExpandableViewHolder
import java.util.ArrayList

/**
 * Created by kiquetal on 1/1/18.
 */
class GuardHeader(id: String) : AbstractItem<GuardHeader.ExpandableHeaderViewHolder>(id),
                                  IExpandable<GuardHeader.ExpandableHeaderViewHolder, GuardItem>, IHeader<GuardHeader.ExpandableHeaderViewHolder> {

    /* Flags for FlexibleAdapter */
    private var mExpanded = false

    /* subItems list */
    private var mGuardItems: MutableList<GuardItem>? = null


    init {
        isDraggable = true
        //We start with header shown and expanded
        isHidden = false
        isExpanded = true
        //NOT selectable (otherwise ActionMode will be activated on long click)!
        isSelectable = false
    }

    override fun isExpanded(): Boolean {
        return mExpanded
    }

    override fun setExpanded(expanded: Boolean) {
        mExpanded = expanded
    }

    override fun getExpansionLevel(): Int {
        return 0
    }

    override fun getSubItems(): List<GuardItem>? {
        return mGuardItems
    }

    fun hasSubItems(): Boolean {
        return mGuardItems != null && mGuardItems!!.size > 0
    }

    fun removeSubItem(item: GuardItem?): Boolean {
        return item != null && mGuardItems!!.remove(item)
    }

    fun removeSubItem(position: Int): Boolean {
        if (mGuardItems != null && position >= 0 && position < mGuardItems!!.size) {
            mGuardItems!!.removeAt(position)
            return true
        }
        return false
    }

    fun addSubItem(guardItem: GuardItem) {
        if (mGuardItems == null)
            mGuardItems = ArrayList()
        mGuardItems!!.add(guardItem)
    }

    fun addSubItem(position: Int, guardItem: GuardItem) {
        if (mGuardItems != null && position >= 0 && position < mGuardItems!!.size) {
            mGuardItems!!.add(position, guardItem)
        } else
            addSubItem(guardItem)
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int {
        return spanCount
    }

    override fun getLayoutRes(): Int {
        return R.layout.recycler_expandable_header_item
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<*>): ExpandableHeaderViewHolder {
        return ExpandableHeaderViewHolder(view, adapter)
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<*>, holder: ExpandableHeaderViewHolder, position: Int, payloads: List<*>) {
        if (payloads.size > 0) {
            Log.d(this.javaClass.simpleName, "ExpandableHeaderItem Payload " + payloads + " - " + getTitle())
        } else {
            Log.d(this.javaClass.simpleName, "ExpandableHeaderItem NoPayload - " + getTitle())
            holder.mTitle.setText(getTitle())
        }
      //  setSubtitle(adapter.getCurrentChildren(this).size.toString() +
       //         " subItems (" + (if (isExpanded) "expanded" else "collapsed") + ")")
     //   setSubtitle("BVC 307 David Noguera")
        holder.mSubtitle.setText(getSubtitle())
    }

    /**
     * Provide a reference to the views for each data item.
     * Complex data labels may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    class ExpandableHeaderViewHolder(view: View, adapter: FlexibleAdapter<*>) : ExpandableViewHolder(view, adapter, true) {

        var mTitle: TextView
        var mSubtitle: TextView
        var mHandleView: ImageView

        init {
            mTitle = view.findViewById(R.id.title)
            mSubtitle = view.findViewById(R.id.subtitle)
            this.mHandleView = view.findViewById(R.id.row_handle)
            if (adapter.isHandleDragEnabled) {
                this.mHandleView.visibility = View.VISIBLE
                setDragHandleView(mHandleView)
            } else {
                this.mHandleView.visibility = View.GONE
            }

            // Support for StaggeredGridLayoutManager
            setFullSpan(true)
        }//True for sticky

        /**
         * Allows to expand or collapse child views of this itemView when [View.OnClickListener]
         * event occurs on the entire view.
         *
         * This method returns always true; Extend with "return false" to Not expand or collapse
         * this ItemView onClick events.
         *
         * @return always true, if not overridden
         * @since 5.0.0-b1
         */
        override fun isViewExpandableOnClick(): Boolean {
            return true//default=true
        }

        /**
         * Allows to collapse child views of this ItemView when [View.OnLongClickListener]
         * event occurs on the entire view.
         *
         * This method returns always true; Extend with "return false" to Not collapse this
         * ItemView onLongClick events.
         *
         * @return always true, if not overridden
         * @since 5.0.0-b1
         */
        override fun isViewCollapsibleOnLongClick(): Boolean {
            return true//default=true
        }

        /**
         * Allows to notify change and rebound this itemView on expanding and collapsing events,
         * in order to update the content (so, user can decide to display the current expanding status).
         *
         * This method returns always false; Override with `"return true"` to trigger the
         * notification.
         *
         * @return true to rebound the content of this itemView on expanding and collapsing events,
         * false to ignore the events
         * @see .expandView
         * @see .collapseView
         * @since 5.0.0-rc1
         */
        override fun shouldNotifyParentOnClick(): Boolean {
            return true//default=false
        }

        /**
         * Expands or Collapses based on the current state.
         *
         * @see .shouldNotifyParentOnClick
         * @see .expandView
         * @see .collapseView
         * @since 5.0.0-b1
         */
        override fun toggleExpansion() {
            super.toggleExpansion() //If overridden, you must call the super method
        }

        /**
         * Triggers expansion of this itemView.
         *
         * If [.shouldNotifyParentOnClick] returns `true`, this view is rebound
         * with payload [Payload.EXPANDED].
         *
         * @see .shouldNotifyParentOnClick
         * @since 5.0.0-b1
         */
        override fun expandView(position: Int) {
            super.expandView(position) //If overridden, you must call the super method
            // Let's notify the item has been expanded. Note: from 5.0.0-rc1 the next line becomes
            // obsolete, override the new method shouldNotifyParentOnClick() as showcased here
            //if (mAdapter.isExpanded(position)) mAdapter.notifyItemChanged(position, true);
        }

        /**
         * Triggers collapse of this itemView.
         *
         * If [.shouldNotifyParentOnClick] returns `true`, this view is rebound
         * with payload [Payload.COLLAPSED].
         *
         * @see .shouldNotifyParentOnClick
         * @since 5.0.0-b1
         */
        override fun collapseView(position: Int) {
            super.collapseView(position) //If overridden, you must call the super method
            // Let's notify the item has been collapsed. Note: from 5.0.0-rc1 the next line becomes
            // obsolete, override the new method shouldNotifyParentOnClick() as showcased here
            //if (!mAdapter.isExpanded(position)) mAdapter.notifyItemChanged(position, true);
        }

    }

    override fun toString(): String {
        return "ExpandableHeaderItem[" + super.toString() + "//SubItems" + mGuardItems + "]"
    }

}