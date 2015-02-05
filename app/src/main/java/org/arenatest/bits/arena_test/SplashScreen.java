package org.arenatest.bits.arena_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 16) {
            setContentView(R.layout.activity_splash_screen);


            pathView = (PathView) findViewById(R.id.pathViewSplash);
            pathView.animatePath(3000);
        }else {

            setContentView(R.layout.splash_screen_duos);

        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(intent);

                SplashScreen.this.finish();


            }
        }, SPLASH_TIME_OUT);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
