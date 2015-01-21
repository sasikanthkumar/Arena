package org.arenatest.bits.arena_test;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.alexvasilkov.foldablelayout.UnfoldableView;


public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;
    public NavigationDrawerFragment drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navdbel);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Home");


        drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)

                        findViewById(R.id.drawer_layout), toolbar

        );

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.frame_container, new ImageGridFragment(this)
        ).

                commit();

    }

    @Override
    public void onBackPressed() {

        Log.d("ff", "" + drawerFragment.getFragNum());
        if (drawerFragment.getFragNum() == 2) {
            UnfoldableView unfoldableView = drawerFragment.getFragment().getmUnfoldableView();
            if (unfoldableView != null && (unfoldableView.isUnfolded() || unfoldableView.isUnfolding())) {
                unfoldableView.foldBack();
            } else {

                super.onBackPressed();
            }
        } else {

            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
