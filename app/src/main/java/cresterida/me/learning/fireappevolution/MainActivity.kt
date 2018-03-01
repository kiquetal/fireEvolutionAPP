package cresterida.me.learning.fireappevolution

import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener
import android.support.v4.widget.DrawerLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.view.ActionMode
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import eu.davidea.fastscroller.FastScroller
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.helpers.UndoHelper
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import android.support.v4.widget.SearchViewCompat.setOnQueryTextListener
import android.support.v4.widget.SearchViewCompat.setSearchableInfo
import android.support.v4.widget.SearchViewCompat.setQueryHint
import android.view.inputmethod.EditorInfo
import android.support.v4.widget.SearchViewCompat.setImeOptions
import android.text.InputType
import android.support.v4.widget.SearchViewCompat.setInputType
import android.support.v4.view.MenuItemCompat
import android.content.Context.SEARCH_SERVICE
import android.app.SearchManager
import android.content.Context
import android.support.v4.view.GravityCompat
import android.view.MenuInflater



class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener,OnFragmentInteractionListener,FlexibleAdapter.OnItemClickListener,SearchView.OnQueryTextListener

{

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        if (mSearchView!=null ) {
            if (mAdapter!=null) {
                 if (mAdapter!!.hasSearchText()) {
                mSearchView!!.setIconifiedByDefault(true)
            } else {
                mSearchView!!.setQuery(mAdapter!!.searchText, false)

            }
            }

        }
            return super.onPrepareOptionsMenu(menu)
    }

    override fun initSearchView(menu: Menu?) {

        var mn :MenuItem =       menu!!.findItem(R.id.action_search)

       mSearchView= mn.actionView as SearchView

        mSearchView!!.setOnQueryTextListener(this)


    }

    override fun onQueryTextSubmit(query: String?): Boolean {
    return onQueryTextChange(query)

    }

    override fun onQueryTextChange(newText: String?): Boolean {

        Log.v("FireApp","buscaremos")
        if (mAdapter!=null) {
            if (mAdapter!!.hasNewSearchText(newText)) {
                Log.v("FireApp","buscar" + newText)

                mAdapter!!.setSearchText(newText)
                mAdapter!!.filterItems(1000L)
            }
        }
        return true
    }

    override fun onItemClick(position: Int): Boolean {
        Log.v("esto","llamando")
            return true
    }


    private var mAdapter: FlexibleAdapter<AbstractFlexibleItem<*>>?=null

    override fun onFragmentChange(swipeRefreshLayout: SwipeRefreshLayout?, recyclerView: RecyclerView?, mode: Int) {

        Log.v("FireApp","recyclerview settled")
        mRecyclerView = recyclerView;
        Log.v("FireApp","mAdapter Settled")
        mAdapter = recyclerView?.adapter as FlexibleAdapter<AbstractFlexibleItem<*>>

        //         mSwipeRefreshLayout = swipeRefreshLayout;
        //         initializeSwipeToRefresh();
        //         initializeActionModeHelper(mode);
             }

       



    private var mFragment:AbstractFragment?=null
    private var mRecyclerView:RecyclerView?=null

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        Log.d("FireAppEvoltion","On menu")
        val id:Int=item.itemId
        Log.v("DEBUG","presionando el drawer")
        Log.d("FireAppEvolution",id.toString())
        when (id) {

            R.id.nav_guard -> mFragment=GuardFragment()
            R.id.nav_codes -> mFragment=HolderFragment()
            R.id.nav_calendar -> mFragment=WeekFragment()
             else -> {
                Log.v("FireApp","No se encontró  el menu!!!")
            }
        }

        if (mFragment!=null)
        {
            Log.d("FireAppEvolution","Fragment")
            item.setChecked(true)
            Log.v("FireApp","checkAdapter")
        //    mAdapter!!.onDetachedFromRecyclerView(mRecyclerView)
            val manager = supportFragmentManager
            manager.beginTransaction().replace(R.id.recycler_view_container,mFragment).commit()
            if (mRecyclerView!=null) {
                mRecyclerView!!.post(Runnable { mDrawer!!.closeDrawer(GravityCompat.START) })
                mDrawer.let { drawerLayout -> drawerLayout!!.closeDrawer(GravityCompat.START)  }
            }else
                mDrawer.let { drawerLayout -> drawerLayout!!.closeDrawer(GravityCompat.START)  }
            return true

        }


       return false

    }



    var toolbar:Toolbar? = null
    var mDrawer:DrawerLayout?=null
    var mNavigationiew:NavigationView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("FireAppEvolution","beforeToolbar")
        this.initializeToolbar()
        this.initializeDrawer()

     }

    fun queHay():Unit {
        Log.d("FireAppEvolution","creando la dondes")

    }
    fun callKiquetal():Unit {
        Log.d("FireAppEvolution", "probando,probando")
    }
        private fun initializeToolbar():Unit {

            toolbar= findViewById<Toolbar>(R.id.toolbar)
            Log.d("FireAppEvolution","initializeToolbar as actionBar");
            setSupportActionBar(toolbar)
            Log.d("FireAppEvolution","included as actionBar");


        }
        private fun initializeDrawer() {
            mDrawer=findViewById<DrawerLayout>(R.id.drawer_layout)
            val toogle= ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
            var addDrawerListener: Unit? = mDrawer?.addDrawerListener(toogle)
            toogle.syncState()
            mNavigationiew=findViewById<NavigationView>(R.id.nav_view)
            var navigationItemSelectedListener = mNavigationiew?.setNavigationItemSelectedListener(this)
            Log.v("FireAppEvolution","iniciando drawer")
        }
    var mSearchView: SearchView? =null

    }
