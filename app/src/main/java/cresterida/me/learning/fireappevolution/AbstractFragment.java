package cresterida.me.learning.fireappevolution;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Davide Steduto
 * @since 15/04/2016
 */
public abstract class AbstractFragment extends Fragment {

    public static final String TAG = AbstractFragment.class.getSimpleName();
    protected static final String ARG_COLUMN_COUNT = "column_count";
    protected static final String ARG_CONFIGURE = "dynamic_list";

    protected int mColumnCount = 2;
    protected RecyclerView mRecyclerView;
    protected FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        //Contribution for specific action buttons in the Toolbar
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.catalogue_main_controller, container, false);
    }

    /**
     * Display FAB button and restore default icon
     */
    protected void initializeFab() {
        mFab = getActivity().findViewById(R.id.fab);
        mFab.setImageResource(R.drawable.fab_add);
        ViewCompat.animate(mFab)
                  .scaleX(1f).scaleY(1f)
                  .alpha(1f).setDuration(100)
                  .setStartDelay(300L)
                  .start();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    public void performFabAction() {
        //default implementation does nothing
    }

    public int getContextMenuResId() {
        //default Menu Context is returned
        return R.menu.menu_context;
    }

    @CallSuper
    public void showNewLayoutInfo(final MenuItem item) {
        item.setEnabled(false);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                item.setEnabled(true);
            }
        }, 1000L);
    }

}