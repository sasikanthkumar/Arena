package org.arenatest.bits.arena_test;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class SponsersFragment extends android.support.v4.app.Fragment {
    private SliderLayout mDemoSliderGallery;
    private SliderLayout mDemoSliderSponsers;
    Context context;


    public SponsersFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sponsers, container, false);
        //added
        if (isNetworkAvailable()) {
            mDemoSliderGallery = (SliderLayout) v.findViewById(R.id.sliderGallery);
            mDemoSliderSponsers = (SliderLayout) v.findViewById(R.id.sliderSponsers);
            HashMap<String, String> url_mapsGallery = new HashMap<String, String>();
            url_mapsGallery.put("image-1", "http://www.bits-arena.com/image/arena-1.jpg");
            url_mapsGallery.put("image-2", "http://www.bits-arena.com/image/arena-2.jpg");
            url_mapsGallery.put("image-3", "http://www.bits-arena.com/image/arena-3.jpg");
            url_mapsGallery.put("image-4", "http://www.bits-arena.com/image/arena-4.jpg");
            url_mapsGallery.put("image-5", "http://www.bits-arena.com/image/arena-5.jpg");
            url_mapsGallery.put("image-6", "http://www.bits-arena.com/image/arena-6.jpg");
            url_mapsGallery.put("image-7", "http://www.bits-arena.com/image/arena-7.jpg");



            for (String name : url_mapsGallery.keySet()) {
                TextSliderView textSliderViewGallery = new TextSliderView(getActivity());
                // initialize a SliderLayout
                textSliderViewGallery
                        .description("Gallery")
                        .image(url_mapsGallery.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);


                //add your extra information
                textSliderViewGallery.getBundle()
                        .putString("extraGallery", name);

                mDemoSliderGallery.addSlider(textSliderViewGallery);
            }
            mDemoSliderGallery.setPresetTransformer(SliderLayout.Transformer.FlipPage);
            mDemoSliderGallery.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSliderGallery.setDuration(4000);


            //sponsers gallery
            HashMap<String, String> url_mapsSponsers = new HashMap<String, String>();
            url_mapsSponsers.put("ONGC", "http://www.jobsandresults.com/wp-content/uploads/2013/01/ONGC-logo-1024x1024.jpg");
            url_mapsSponsers.put("Idea", "http://images.fonearena.com/blog/wp-content/uploads/2011/03/Idea-3G-launch.jpg");
            url_mapsSponsers.put("State Bank of India", "http://kikkidu.com/wp-content/uploads/2011/07/sbi.jpg");
            url_mapsSponsers.put("Sony", "http://redpilltimes.com/wp-content/uploads/2014/12/Sony-logo.jpg");
            url_mapsSponsers.put("The Times of India","http://www.stopgendercide.org/wp-content/uploads/2014/11/Times-of-India-abortion.jpg");
            url_mapsSponsers.put("Airtel","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZKrYLAcLtqrHqO4s5uyJP1ndVC-ilMB45tx16DPaEFjXyH2jdHA");


            for (String name : url_mapsSponsers.keySet()) {
                TextSliderView textSliderViewSponsers = new TextSliderView(getActivity());
                // initialize a SliderLayout
                textSliderViewSponsers
                        .description(name)
                        .image(url_mapsSponsers.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);


                //add your extra information
                textSliderViewSponsers.getBundle()
                        .putString("extraSponsers", name);

                mDemoSliderSponsers.addSlider(textSliderViewSponsers);
            }
            mDemoSliderSponsers.setPresetTransformer(SliderLayout.Transformer.CubeIn);
            mDemoSliderSponsers.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSliderSponsers.setCustomAnimation(new DescriptionAnimation());
            mDemoSliderSponsers.setDuration(4000);

        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_LONG).show();

        }
        //added
        return v;

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }


}
