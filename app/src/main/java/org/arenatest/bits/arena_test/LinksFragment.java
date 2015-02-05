package org.arenatest.bits.arena_test;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class LinksFragment extends android.support.v4.app.Fragment {
    Context context;

    public LinksFragment() {
        // Required empty public constructor

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_links, container, false);

        Button register = (Button) v.findViewById(R.id.register);
        ImageButton fb = (ImageButton) v.findViewById(R.id.fb);
        ImageButton youtube = (ImageButton) v.findViewById(R.id.youtube);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1teThiUsH2MwwF2AdDMGuhyPXiaHBhXbNBKM7AM0xDfQ/viewform?c=0&w=1"));
                startActivity(browserIntent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bits.arena"));
                startActivity(browserIntent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Cj5Ko8t4MeE&channel=UC7zmJovCGy9MqKmCtjL2hKw"));
                startActivity(browserIntent);
            }
        });


        return v;
    }


}