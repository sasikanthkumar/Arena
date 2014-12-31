package org.arenatest.bits.arena_test;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    RelativeLayout arena15rl, arena14rl, directorrl;
    CardView arena15, arena14, director;
    FloatingActionButton floatab;
    Boolean flagAbout = false;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_about, container, false);
        arena15rl = (RelativeLayout) layout.findViewById(R.id.arena15rl);
        arena14rl = (RelativeLayout) layout.findViewById(R.id.arena14rl);
        directorrl = (RelativeLayout) layout.findViewById(R.id.directorrl);
        floatab = (FloatingActionButton) layout.findViewById(R.id.floatab);
        //arena15= (CardView) layout.findViewById(R.id.arena15);
        //arena14= (CardView) layout.findViewById(R.id.arena14);
        //director= (CardView) layout.findViewById(R.id.director);
        //arena15.setOnClickListener(this);
        //arena14.setOnClickListener(this);
        //director.setOnClickListener(this);
        floatab.setOnClickListener(this);
        arena15rl.setOnClickListener(this);
        arena14rl.setOnClickListener(this);
        directorrl.setOnClickListener(this);
        return layout;
    }


    @Override
    public void onClick(View v) {
        if (!flagAbout) {
            flagAbout = true;
            Dialog d = new Dialog(v.getContext());
            d.getWindow().getAttributes().windowAnimations = R.style.dialog_animation_fade;
            d.setContentView(R.layout.dialog_aboutus);
            d.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    flagAbout = false;
                }
            });
            d.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    flagAbout = false;
                }
            });
            TextView aboutus_text = (TextView) d.findViewById(R.id.aboutus_text);
            switch (v.getId()) {
                case R.id.arena15rl:
                    d.setTitle("Arena 15");
                    aboutus_text.setText(R.string.aboutus_arena15);
                    d.show();
                    break;
                case R.id.arena14rl:
                    d.setTitle("Arena 14");
                    aboutus_text.setText(R.string.aboutus_arena14);
                    d.show();
                    break;
                case R.id.directorrl:
                    d.setTitle("From the Directors Desk");
                    aboutus_text.setText(R.string.aboutus_director);
                    d.show();
                    break;
                case R.id.floatab:
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/bits.arena"));
                    startActivity(intent);
                    flagAbout=false;
                    break;

            }
        }
    }
}
