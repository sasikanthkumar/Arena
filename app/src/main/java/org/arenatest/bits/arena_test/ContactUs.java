package org.arenatest.bits.arena_test;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends android.support.v4.app.Fragment implements View.OnClickListener {
    LinearLayout harsha1, battar2, mrudul3, snehith4, srivani5;
    Boolean flag = false;


    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_contact_us, container, false);
        harsha1 = (LinearLayout) layout.findViewById(R.id.harsha1);
        battar2 = (LinearLayout) layout.findViewById(R.id.battar2);
        mrudul3 = (LinearLayout) layout.findViewById(R.id.mrudul3);
        snehith4 = (LinearLayout) layout.findViewById(R.id.snehith4);
        srivani5 = (LinearLayout) layout.findViewById(R.id.srivani5);
        harsha1.setOnClickListener(this);
        battar2.setOnClickListener(this);
        mrudul3.setOnClickListener(this);
        snehith4.setOnClickListener(this);
        srivani5.setOnClickListener(this);


        return layout;
    }


    @Override
    public void onClick(View v) {
        if (!flag) {
            flag=true;
            Dialog dialog = new Dialog(v.getContext());
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    flag=false;
                }
            });
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    flag=false;
                }
            });

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog);
            TextView phoneText = (TextView) dialog.findViewById(R.id.phoneText);
            TextView emailText = (TextView) dialog.findViewById(R.id.emailText);
            dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;


            switch (v.getId()) {

                case R.id.harsha1:
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

            }


        }
    }
}


