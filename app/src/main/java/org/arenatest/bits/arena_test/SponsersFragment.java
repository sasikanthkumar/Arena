package org.arenatest.bits.arena_test;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class SponsersFragment extends android.support.v4.app.Fragment {
    private MyGridView gridSponsers, tempGrid;
    private Context contextEvents;
    private ScrollView scrollView;
    private SliderLayout sponsGallery;
    private HashMap<String, String> url_mapsSponsers;
    private TextSliderView textSliderViewSponsers;

    public SponsersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.contextEvents = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sponsers, container, false);
        int imgs1[] = {R.drawable.athletics_final, R.drawable.volleyball_final, R.drawable.tennis_final, R.drawable.badminton_final, R.drawable.athletics_final, R.drawable.badminton_final, R.drawable.athletics_final, R.drawable.athletics_final};
        int imgs2[] = {R.drawable.solid_black};
        gridSponsers = (MyGridView) v.findViewById(R.id.gridSponsers);
        tempGrid = (MyGridView) v.findViewById(R.id.tempGrid);
        scrollView = (ScrollView) v.findViewById(R.id.bizScrollView);
        //gridSponsers.setExpanded(true);
        tempGrid.setAdapter(new ImageAdapter(contextEvents, imgs2));
        gridSponsers.setAdapter(new ImageAdapter(contextEvents, imgs1));
        //gridSponsers.setExpanded(true);
        if (isNetworkAvailable()) {
            sponsGallery = (SliderLayout) v.findViewById(R.id.sponsGallery);
            url_mapsSponsers = new HashMap<String, String>();
            url_mapsSponsers.put("Aircel", "http://www.mymobile.co.in/wp-content/uploads/2014/03/Aircel4.jpg");
            url_mapsSponsers.put("Quicksilver", "http://www.viewlogo.com/wp-content/uploads/2013/08/Quiksilve-Logo.jpg");
            url_mapsSponsers.put("Kajaria", "http://rajasthanpedia.com/wp-content/uploads/2013/01/Kajaria-Ceramics-Logo.jpg");
            url_mapsSponsers.put("ONGC", "http://www.jobsandresults.com/wp-content/uploads/2013/01/ONGC-logo-1024x1024.jpg");
            url_mapsSponsers.put("Orange tours and travels", "http://img.click.in/classifieds/images/148/26_4_2012_17_01_1178_new_logo1234copy.jpg");
            url_mapsSponsers.put("State Bank of India", "http://kikkidu.com/wp-content/uploads/2011/07/sbi.jpg");
            url_mapsSponsers.put("The Bike Affair", "http://www.thebikeaffair.com/images/logo.jpg");
            url_mapsSponsers.put("Servo", "http://www.triangletennis.org/passingshot/sep12/images/sep%202012/SERVO%20LOGO.jpg");


            for (String name : url_mapsSponsers.keySet()) {
                textSliderViewSponsers = new TextSliderView(getActivity());
                textSliderViewSponsers
                        .description(name)
                        .image(url_mapsSponsers.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);


                textSliderViewSponsers.getBundle()
                        .putString("extraSponsers", name);

                sponsGallery.addSlider(textSliderViewSponsers);
            }

            sponsGallery.setPresetTransformer(SliderLayout.Transformer.FlipPage);
            sponsGallery.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sponsGallery.setDuration(4000);
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_LONG).show();

        }
        return v;

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) contextEvents.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }


    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();

        if (isNetworkAvailable()) {
            sponsGallery.stopAutoCycle();
        }
        //Log.d("bbb", "url");
        textSliderViewSponsers = null;

    }
}

class ImageAdapter extends BaseAdapter {
    Context context;
    private int[] imgs;

    public ImageAdapter(Context context, int[] imgs) {
        this.imgs = imgs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return imgs[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderSpons holderSpons = null;
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (imgs.length == 1) {
                rowView = layoutInflater.inflate(R.layout.spons_gallery, parent, false);
            } else {
                rowView = layoutInflater.inflate(R.layout.spons_grid, parent, false);

            }

            holderSpons = new HolderSpons();
            holderSpons.img = (ImageView) rowView.findViewById(R.id.imageViewSpons);

            rowView.setTag(holderSpons);
        } else {
            holderSpons = (HolderSpons) rowView.getTag();
        }
        //String[] b = {"http://www.mymobile.co.in/wp-content/uploads/2014/03/Aircel4.jpg", "http://www.jobsandresults.com/wp-content/uploads/2013/01/ONGC-logo-1024x1024.jpg", "http://images.fonearena.com/blog/wp-content/uploads/2011/03/Idea-3G-launch.jpg", "http://kikkidu.com/wp-content/uploads/2011/07/sbi.jpg", "http://redpilltimes.com/wp-content/uploads/2014/12/Sony-logo.jpg", "http://www.stopgendercide.org/wp-content/uploads/2014/11/Times-of-India-abortion.jpg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZKrYLAcLtqrHqO4s5uyJP1ndVC-ilMB45tx16DPaEFjXyH2jdHA"};
        String[] b = {"http://www.mymobile.co.in/wp-content/uploads/2014/03/Aircel4.jpg", "http://www.viewlogo.com/wp-content/uploads/2013/08/Quiksilve-Logo.jpg", "http://rajasthanpedia.com/wp-content/uploads/2013/01/Kajaria-Ceramics-Logo.jpg", "http://www.jobsandresults.com/wp-content/uploads/2013/01/ONGC-logo-1024x1024.jpg", "http://img.click.in/classifieds/images/148/26_4_2012_17_01_1178_new_logo1234copy.jpg", "http://kikkidu.com/wp-content/uploads/2011/07/sbi.jpg", "http://www.thebikeaffair.com/images/logo.jpg", "http://www.triangletennis.org/passingshot/sep12/images/sep%202012/SERVO%20LOGO.jpg"};
        Picasso.with(context).load(b[position]).fit().into(holderSpons.img);


        return rowView;
    }

    public class HolderSpons {
        ImageView img;

    }
}

