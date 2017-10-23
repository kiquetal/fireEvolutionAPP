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

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener,OnFragmentInteractionListener,FlexibleAdapter.OnItemClickListener

{
    override fun onItemClick(position: Int): Boolean {
        Log.v("esto","llamando")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initSearchView(menu: Menu?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mAdapter: FlexibleAdapter<AbstractFlexibleItem<*>>?=null

    override fun onFragmentChange(swipeRefreshLayout: SwipeRefreshLayout?, recyclerView: RecyclerView?, mode: Int) {

        Log.v(this.toString(),"changed")
        mRecyclerView = recyclerView;
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

            R.id.nav_guard -> mFragment=HolderFragment()
            else -> {
                Log.v("FireApp","No se enctron el menu!!!")
            }
        }

        if (mFragment!=null)
        {
            Log.d("FireAppEvolution","Fragment")
            item.setChecked(true)
            val manager = supportFragmentManager
            manager.beginTransaction().replace(R.id.recycler_view_container,mFragment).commit()
            return true

        }


       return false

    }

    var toolbar = null
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
            navigationItemSelectedListener
            Log.v("FireAppEvolution","iniciando drawer")
        }
    }
