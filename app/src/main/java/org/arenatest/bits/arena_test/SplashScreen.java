package org.arenatest.bits.arena_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Timer timer = new Timer();
        setContentView(R.layout.activity_splash_screen);
       /* TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        TextView tv6 = (TextView) findViewById(R.id.tv6);
        TextView tv7 = (TextView) findViewById(R.id.tv7);
        TextView tv8 = (TextView) findViewById(R.id.tv8);
        TextView tv9 = (TextView) findViewById(R.id.tv9);
        TextView tv10 = (TextView) findViewById(R.id.tv10);
        TextView tv11 = (TextView) findViewById(R.id.tv11);
        TextView tv12 = (TextView) findViewById(R.id.tv12);
        TextView tv13 = (TextView) findViewById(R.id.tv13);
        TextView tv14 = (TextView) findViewById(R.id.tv14);
        TextView tv15 = (TextView) findViewById(R.id.tv15);
        TextView tv16 = (TextView) findViewById(R.id.tv16);*/

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(intent);

                SplashScreen.this.finish();

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        }, SPLASH_TIME_OUT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, SPLASH_TIME_OUT);


    }


}
