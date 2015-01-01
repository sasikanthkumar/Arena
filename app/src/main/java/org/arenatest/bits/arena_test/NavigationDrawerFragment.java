package org.arenatest.bits.arena_test;


import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {


    private RecyclerView recyclerView;
    public String actionBarTitle = "HOME";
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


    public NavigationDrawerFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        navDrawerList = (ListView) layout.findViewById(R.id.naviDrawerList);
        adapterList = new MyAdapterList(getActivity());
        navDrawerList.setAdapter(adapterList);

        navDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temp;
                for (int j = 0; j < parent.getChildCount(); j++) {
                    temp = (TextView) parent.getChildAt(j).findViewById(R.id.listText);
                    temp.setTextColor(Color.BLACK);
                }
                temp = (TextView) view.findViewById(R.id.listText);
                temp.setTextColor(Color.BLUE);


                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new HomeFragment();
                        actionBarTitle = "Home";
                        preFragNum = 0;
                        break;
                    case 1:
                        fragment = new EventsFragment();
                        actionBarTitle = "Events";
                        preFragNum = 1;
                        break;
                    case 2:
                        fragment = new MapsFragment();
                        actionBarTitle = "Maps";
                        preFragNum = 2;
                        break;
                    case 3:
                        fragment = new AboutFragment();
                        actionBarTitle = "About Us";
                        preFragNum = 3;
                        break;
                    case 4:
                        fragment = new ContactUs();
                        actionBarTitle = "Contact Us";
                        preFragNum = 4;
                        break;
                    case 5:
                        fragment=new SponsersFragment(getActivity());
                        actionBarTitle="Sponsers/Gallery";
                        preFragNum = 5;
                        break;
                }
                if (fragment != null && prevFragNum != preFragNum) {
                    prevFragNum = preFragNum;
                    FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.setCustomAnimations(R.anim.activity_open_translate, R.anim.activity_close_scale);
                    ft.replace(R.id.frame_container, fragment);
                    ft.commit();
                    mDrawerLayout.closeDrawer(containerView);


                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                    mDrawerLayout.closeDrawer(containerView);

                }
            }

        });


        //added by me */
        return layout;
    }

    public static List<Information> getData() {

        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon};
        String[] titles = {"Home", "Events", "Maps", "About", "Contact Us"};
        for (int i = 0; i < titles.length && i < titles.length; i++) {
            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }


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


}

/*class MyListAdapter extends BaseAdapter {

    private Context contextList;
    int[] iconsList = {R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon};
    String[] titlesList = {"Home", "Events", "Maps", "About", "Contact Us"};


    public MyListAdapter(Context contextList) {
        this.contextList = contextList;


    }

    @Override
    public int getCount() {
        return titlesList.length;
    }

    @Override
    public Object getItem(int position) {
        return titlesList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowList = null;

        if (convertView == null) {
            LayoutInflater inflaterList = (LayoutInflater) contextList.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowList = inflaterList.inflate(R.layout.custom_row, parent, false);


        } else {
            rowList=convertView;



        }
        TextView textViewList= (TextView) rowList.findViewById(R.id.listText);
        ImageView imageViewList= (ImageView) rowList.findViewById(R.id.listIcon);
        textViewList.setText(titlesList[position]);
        imageViewList.setImageResource(iconsList[position]);
        return null;
    }
}*/

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
    Boolean flag=Boolean.TRUE;


    MyAdapterList(Context contextListnav) {
        this.contextListnav = contextListnav;
        listNav = new ArrayList<NavdrawerListItem>();
        Resources resnavList = contextListnav.getResources();
        String tempIconNames[] = {"Home", "Events", "Maps", "AboutUs", "ContactUs","Sponsers/Gallery"};
        int tempIconImages[] = {R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon, R.drawable.drawericon,R.drawable.drawericon};
        for (int i = 0; i < 6; i++) {
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
        if (flag==Boolean.TRUE && i==0){
            holdernavList.myListNamenav.setTextColor(Color.BLUE);
            flag=Boolean.FALSE;

        }

        holdernavList.myListnav.setImageResource(tempItem.imageIdnav);
        holdernavList.myListnav.setTag(tempItem);
        return rowNav;
    }
}



