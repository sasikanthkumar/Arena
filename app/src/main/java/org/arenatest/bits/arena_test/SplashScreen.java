package org.arenatest.bits.arena_test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splash_thread=new Thread(){
            public void run(){
                try{
                    sleep(SPLASH_TIME_OUT);
                    Intent splash_intent;
                    splash_intent = new Intent(SplashScreen.this, MainActivity.class);
                    splash_intent.putExtra("Exit me", false);
                    startActivity(splash_intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();

                }

            }

        };
        splash_thread.start();



    }



}
