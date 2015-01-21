package org.arenatest.bits.arena_test;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends android.support.v4.app.Fragment implements View.OnClickListener {
    LinearLayout harsha1, battar2, mrudul3, snehith4, srivani5;
    Boolean flag = false;
    CircleImageView harsha, battar, srivani, mrudul, snehith;
    Context c;

    public ContactUs(Context c) {
        this.c = c;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater1, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("hhh", "hhhh");
        View layout = inflater1.inflate(R.layout.fragment_contact_us, container, false);
        //harsha = (CircleImageView) layout.findViewById(R.id.view);
        //battar = (CircleImageView) layout.findViewById(R.id.view2);
        //snehith = (CircleImageView) layout.findViewById(R.id.view4);
        //srivani = (CircleImageView) layout.findViewById(R.id.view5);
        //mrudul = (CircleImageView) layout.findViewById(R.id.view3);

        Picasso.with(c).load(R.drawable.ic_drawer_aboutus).into(harsha);
        Picasso.with(c).load(R.drawable.ic_drawer_aboutus).into(battar);
        Picasso.with(c).load(R.drawable.ic_drawer_aboutus).into(srivani);
        Picasso.with(c).load(R.drawable.ic_drawer_aboutus).into(mrudul);
        Picasso.with(c).load(R.drawable.ic_drawer_aboutus).into(snehith);
        //harsha.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.drawable.harsha, 100, 100));
        // battar.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.drawable.battar, 100, 100));
        // snehith.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.drawable.snehith, 100, 100));
        // srivani.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.drawable.srivani, 100, 100));
        /// mrudul.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.drawable.mrudul, 100, 100));


        //harsha1 = (LinearLayout) layout.findViewById(R.id.harsha1);
        //battar2 = (LinearLayout) layout.findViewById(R.id.battar2);
       /* mrudul3 = (LinearLayout) layout.findViewById(R.id.mrudul3);
        snehith4 = (LinearLayout) layout.findViewById(R.id.snehith4);
        srivani5 = (LinearLayout) layout.findViewById(R.id.srivani5);
        harsha1.setOnClickListener(this);
        battar2.setOnClickListener(this);
        mrudul3.setOnClickListener(this);
        snehith4.setOnClickListener(this);
        srivani5.setOnClickListener(this);*/


        return layout;
    }


    @Override
    public void onClick(View v) {
        if (!flag) {
            flag = true;
            Dialog dialog = new Dialog(v.getContext());
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    flag = false;
                }
            });
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    flag = false;
                }
            });

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog);
            TextView phoneText = (TextView) dialog.findViewById(R.id.phoneText);
            TextView emailText = (TextView) dialog.findViewById(R.id.emailText);
            dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;


            switch (v.getId()) {

               /* case R.id.harsha1:
                    phoneText.setText("+91-9032775678");
                    emailText.setText("harsha@bits-arena.com");
                    dialog.show();
                    break;
                case R.id.battar2:
                    phoneText.setText("+91-8464992947");
                    emailText.setText("shashank@bits-arena.com");
                    emailText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                    dialog.show();
                    break;
                case R.id.mrudul3:
                    phoneText.setText("+91-9542553851");
                    emailText.setText("mrudul@bits-arena.com");
                    dialog.show();
                    break;
                case R.id.snehith4:
                    phoneText.setText("+91-9618102392");
                    emailText.setText("snehith@bits-arena.com");
                    dialog.show();
                    break;
                case R.id.srivani5:
                    phoneText.setText("+91-9912702673");
                    emailText.setText("shrivani@bits-arena.com");
                    dialog.show();
                    break;
*/
            }


        }
    }
}


