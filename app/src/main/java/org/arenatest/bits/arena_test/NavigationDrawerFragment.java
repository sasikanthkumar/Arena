package org.arenatest.bits.arena_test;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {


    public String actionBarTitle = "Home";
    public boolean abColor = true;
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToogle;
    private DrawerLayout mDrawerLayout;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;
    private boolean isDrawerOpened = false;
    private ListView navDrawerList;
    public int prevFragNum = 0;
    private int preFragNum;
    private MyAdapterList adapterList;
    private Fragment retFragment;
    private FoldableAboutFragment testRetFrag;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        navDrawerList = (ListView) layout.findViewById(R.id.naviDrawerList);
        adapterList = new MyAdapterList(getActivity());
        navDrawerList.setAdapter(adapterList);

        navDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View tempView;
                for (int j = 0; j < parent.getChildCount(); j++) {
                    tempView = parent.getChildAt(j);
                    formatNavDrawerItem(tempView, false);
                }
                formatNavDrawerItem(view, true);

                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                FoldableAboutFragment fragment1 = null;

                switch (position) {
                    case 0:
                        fragment = new ImageGridFragment();
                        actionBarTitle = "Home";
                        abColor = true;
                        preFragNum = 0;
                        break;
                    case 1:
                        fragment = new MapsFragment();
                        actionBarTitle = "Maps";
                        abColor = false;
                        preFragNum = 1;
                        break;
                    case 2:
                        fragment1 = new FoldableAboutFragment();

                        fragment = new LinksFragment();
                        actionBarTitle = "About Us";
                        abColor = false;
                        preFragNum = 2;
                        break;
                    case 3:
                        fragment = new ImageListFragment();
                        actionBarTitle = "Contact Us";
                        preFragNum = 3;
                        abColor = false;
                        break;
                    case 4:
                        fragment = new SponsersFragment();
                        actionBarTitle = "Sponsors";
                        preFragNum = 4;
                        abColor = false;
                        break;

                    case 5:
                        fragment = new DiscrollFragment();
                        actionBarTitle = "Links";
                        preFragNum = 5;
                        abColor = false;
                        break;
                    case 6:
                        fragment = new RegisterFragment();
                        actionBarTitle = "Register";
                        preFragNum = 6;
                        abColor = false;
                        break;
                    case 7:
                        fragment = new UpdatesFragment();
                        actionBarTitle = "Updates";
                        preFragNum = 7;
                        abColor = false;
                        break;

                }
                if (fragment != null && prevFragNum != preFragNum) {
                    testRetFrag = fragment1;


                    if (actionBarTitle.equals("About Us")) {
                        prevFragNum = preFragNum;
                        mDrawerLayout.closeDrawer(containerView);

                        fragmentManager = getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.setCustomAnimations(R.anim.activity_open_translate, R.anim.zoom_exit);

                        ft.replace(R.id.frame_container, fragment1);


                        ft.commit();

                    } else {
                        prevFragNum = preFragNum;
                        mDrawerLayout.closeDrawer(containerView);

                        fragmentManager = getFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.setCustomAnimations(R.anim.activity_open_translate, R.anim.zoom_exit);

                        ft.replace(R.id.frame_container, fragment);


                        ft.commit();
                    }


                } else {
                    //Log.e("MainActivity", "Error in creating fragment");
                    mDrawerLayout.closeDrawer(containerView);


                }
            }

        });


        return layout;
    }

    private void formatNavDrawerItem(View view, boolean selected) {
        ImageView iconView = (ImageView) view.findViewById(R.id.listIcon);
        TextView titleView = (TextView) view.findViewById(R.id.listText);

        titleView.setTextColor(selected ?
                getResources().getColor(R.color.navdrawer_text_color_selected) :
                getResources().getColor(R.color.navdrawer_text_color));
        iconView.setColorFilter(selected ?
                getResources().getColor(R.color.navdrawer_icon_tint_selected) :
                getResources().getColor(R.color.navdrawer_icon_tint));
    }

   /* public static List<Information> getData() {

        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon};
        String[] titles = {"Home", "Events", "Maps", "About", "Contact Us"};
        for (int i = 0; i < titles.length && i < titles.length; i++) {
            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }*/


    public void setUp(int fragment_id, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragment_id);
        mDrawerLayout = drawerLayout;
        mDrawerToogle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");

                }
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setTitle(actionBarTitle);
                if (abColor) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        //getActivity().getWindow().setStatusBarColor(Color.BLACK);

                    }
                } else {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        //getActivity().getWindow().setStatusBarColor(Color.BLACK);

                    }
                }
                getActivity().invalidateOptionsMenu();

            }


        };


        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(containerView);

        }
        mDrawerLayout.setDrawerListener(mDrawerToogle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToogle.syncState();
            }
        });
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }


    public int getFragNum() {
        return preFragNum;
    }

    public FoldableAboutFragment getFragment() {
        return testRetFrag;
    }
}

class NavdrawerListItem {
    int imageIdnav;
    String imageNamenav;

    NavdrawerListItem(int imageIdnav, String imageNamenav) {
        this.imageIdnav = imageIdnav;
        this.imageNamenav = imageNamenav;


    }

}

class ViewHoldernavList {
    ImageView myListnav;
    TextView myListNamenav;

    ViewHoldernavList(View v) {
        myListnav = (ImageView) v.findViewById(R.id.listIcon);
        myListNamenav = (TextView) v.findViewById(R.id.listText);


    }

}

class MyAdapterList extends BaseAdapter {
    ArrayList<NavdrawerListItem> listNav;
    Context contextListnav;
    Boolean flag = Boolean.TRUE;


    MyAdapterList(Context contextListnav) {
        this.contextListnav = contextListnav;
        listNav = new ArrayList<NavdrawerListItem>();
        Resources resnavList = contextListnav.getResources();
        String tempIconNames[] = {"Home", "Maps", "AboutUs", "ContactUs", "Sponsors", "Links", "Register", "Updates"};
        int tempIconImages[] = {R.drawable.ic_drawer_home, R.drawable.ic_drawer_maps, R.drawable.ic_drawer_aboutus, R.drawable.ic_drawer_contactus, R.drawable.ic_drawer_sponsers, R.drawable.ic_language_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_sync_black_24dp};
        for (int i = 0; i < 8; i++) {
            NavdrawerListItem temp = new NavdrawerListItem(tempIconImages[i], tempIconNames[i]);
            listNav.add(temp);

        }


    }


    @Override
    public int getCount() {
        return listNav.size();
    }

    @Override
    public Object getItem(int position) {
        return listNav.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowNav = view;
        ViewHoldernavList holdernavList = null;
        if (rowNav == null) {
            LayoutInflater inflaterNav = (LayoutInflater) contextListnav.getSystemService(contextListnav.LAYOUT_INFLATER_SERVICE);
            rowNav = inflaterNav.inflate(R.layout.custom_row, viewGroup, false);
            holdernavList = new ViewHoldernavList(rowNav);
            rowNav.setTag(holdernavList);

        } else {

            holdernavList = (ViewHoldernavList) rowNav.getTag();
        }
        NavdrawerListItem tempItem = listNav.get(i);
        holdernavList.myListNamenav.setText(tempItem.imageNamenav);


        if (flag == Boolean.TRUE && i == 0) {
            holdernavList.myListNamenav.setTextColor(contextListnav.getResources().getColor(R.color.navdrawer_text_color_selected));
            holdernavList.myListnav.setColorFilter(contextListnav.getResources().getColor(R.color.navdrawer_icon_tint_selected));
            flag = Boolean.FALSE;

        } else {
            holdernavList.myListNamenav.setTextColor(contextListnav.getResources().getColor(R.color.navdrawer_text_color));
            holdernavList.myListnav.setColorFilter(contextListnav.getResources().getColor(R.color.navdrawer_icon_tint));

        }

        holdernavList.myListnav.setImageResource(tempItem.imageIdnav);
        holdernavList.myListnav.setTag(tempItem);
        return rowNav;
    }
}



