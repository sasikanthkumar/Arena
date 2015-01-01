package org.arenatest.bits.arena_test;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;


public class HomeFragment extends android.support.v4.app.Fragment {
    private GridView myGridHome;
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;


    public HomeFragment() {
    }


    //added

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        myGridHome = (GridView) rootView.findViewById(R.id.gridView);


        //added

        tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        Button regiater_button = (Button) rootView.findViewById(R.id.register_button);
        regiater_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bits-arena.com/form.html"));
                startActivity(myIntent);
            }
        });
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        tabs.setIndicatorColor(Color.parseColor("#636161"));
        adapter = new MyPagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);

        //added

        myGridHome.setAdapter(new MyAdapterHome(getActivity()));
        myGridHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentHome = new Intent(view.getContext(), Parallax_GridItem.class);
                ViewHolderHome holderHome = (ViewHolderHome) view.getTag();
                SportHome tempHome = (SportHome) holderHome.mySportHome.getTag();
                intentHome.putExtra("sportImage", tempHome.imageIdHome);
                intentHome.putExtra("sportName", tempHome.sportNameHome);
                intentHome.putExtra("Position", position);
                try {
                    startActivity(intentHome);

                } catch (Exception e) {
                    Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }


        });
        return rootView;
    }

}

class SportHome {

    int imageIdHome;
    String sportNameHome;

    SportHome(int imageIdHome, String sportNameHome) {
        this.imageIdHome = imageIdHome;
        this.sportNameHome = sportNameHome;
    }
}

class ViewHolderHome {
    ImageView mySportHome;
    TextView mySportNameHome;

    ViewHolderHome(View v) {
        mySportHome = (ImageView) v.findViewById(R.id.imageView);
        mySportNameHome = (TextView) v.findViewById(R.id.textView);


    }


}

class MyAdapterHome extends BaseAdapter {
    ArrayList<SportHome> listHome;
    Context contextHome;

    MyAdapterHome(Context contextHome) {
        this.contextHome = contextHome;
        listHome = new ArrayList<SportHome>();
        Resources resHome = contextHome.getResources();
        String[] tempSportNamesHome = resHome.getStringArray(R.array.sport_names);
        int[] sportImagesHome = {R.drawable.athletics, R.drawable.football, R.drawable.badminton, R.drawable.cricket, R.drawable.hockey, R.drawable.basketball, R.drawable.carrom, R.drawable.chess, R.drawable.lawntennis, R.drawable.tabletennis, R.drawable.snooker, R.drawable.kabaddi, R.drawable.powerlifting, R.drawable.volleyball, R.drawable.ultimatefrisbee, R.drawable.duathlon};
        for (int i = 0; i < 16; i++) {
            SportHome tempSportHome = new SportHome(sportImagesHome[i], tempSportNamesHome[i]);
            listHome.add(tempSportHome);

        }


    }


    @Override
    public int getCount() {
        return listHome.size();
    }

    @Override
    public Object getItem(int i) {
        return listHome.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowHome = view;
        ViewHolderHome holderHome = null;
        if (rowHome == null) {
            LayoutInflater inflaterHome = (LayoutInflater) contextHome.getSystemService(contextHome.LAYOUT_INFLATER_SERVICE);
            rowHome = inflaterHome.inflate(R.layout.single_grid_item, viewGroup, false);
            holderHome = new ViewHolderHome(rowHome);
            rowHome.setTag(holderHome);

        } else {
            holderHome = (ViewHolderHome) rowHome.getTag();

        }
        SportHome tempHome = listHome.get(i);
        holderHome.mySportHome.setImageResource(tempHome.imageIdHome);
        holderHome.mySportNameHome.setText(tempHome.sportNameHome);
        holderHome.mySportHome.setTag(tempHome);

        Animation animation= AnimationUtils.loadAnimation(contextHome,R.anim.scale);
        rowHome.startAnimation(animation);



        return rowHome;
    }


}

class MyPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"Football", "Badminton", "Cricket", "Hockey", "Basketball", "Carrom", "Chess", "Lawn Tennis", "Table Tennis", "Power Lifting", "Volleyball"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return new EventManagersFragment(position);
    }


}

