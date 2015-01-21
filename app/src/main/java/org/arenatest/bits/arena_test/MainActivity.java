package org.arenatest.bits.arena_test;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manuelpeinado.fadingactionbar.view.ObservableScrollable;
import com.manuelpeinado.fadingactionbar.view.OnScrollChangedCallback;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends ActionBarActivity   {
    private Toolbar toolbar;
    public NavigationDrawerFragment drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navdbel);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.getBackground().setAlpha(255);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Home");

        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(R.color.trans));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);

        }

        drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)

                        findViewById(R.id.drawer_layout), toolbar

        );
        //added
        //
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.frame_container, new ImageGridFragment(this)
        ).

                commit();

        //added
    }

    @Override
    public void onBackPressed() {

        Log.d("ff", "" + drawerFragment.getFragNum());
        if (drawerFragment.getFragNum() == 2) {
            UnfoldableView unfoldableView = drawerFragment.getFragment().getmUnfoldableView();
            if (unfoldableView != null && (unfoldableView.isUnfolded() || unfoldableView.isUnfolding())) {
                unfoldableView.foldBack();
            } else {
                //Intent intent = new Intent(Intent.ACTION_MAIN);
                //intent.addCategory(Intent.CATEGORY_HOME);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
                super.onBackPressed();
            }
        } else {
            //Intent intent = new Intent(Intent.ACTION_MAIN);
            //intent.addCategory(Intent.CATEGORY_HOME);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //startActivity(intent);
            super.onBackPressed();
        }

        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //if (id == R.id.navigate) {
        //startActivity(new Intent(this, SubActivity.class));

        //}
        return super.onOptionsItemSelected(item);
    }





}
