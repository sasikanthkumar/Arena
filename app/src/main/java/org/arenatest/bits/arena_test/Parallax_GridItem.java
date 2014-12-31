package org.arenatest.bits.arena_test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Parallax_GridItem extends ActionBarActivity {
    String sportName;
    int imageId;
    int position;

    Random random=new Random();
    int colorPosition;
    String ActionBarColors[];
    String StatusBarColors[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
        ActionBarColors=getResources().getStringArray(R.array.ActionBarColors);
        StatusBarColors=getResources().getStringArray(R.array.StatusBarColors);
        colorPosition=random.nextInt(10);
        Log.d(colorPosition+"","colorPosition");

        try {


            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(ActionBarColors[colorPosition])));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                getWindow().setStatusBarColor(Color.parseColor(StatusBarColors[colorPosition]));

        }catch (Exception e){
            e.printStackTrace();

        }

        getSupportActionBar().setHomeButtonEnabled(true);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        if (intent != null) {

            imageId = intent.getIntExtra("sportImage", R.drawable.athletics);
            sportName = intent.getStringExtra("sportName");
            position = intent.getIntExtra("Position", 0);


        }
        switch (position) {
            case 0:
                setContentView(R.layout.athletics);
                ImageView myImage0 = (ImageView) findViewById(R.id.imageView2);
                myImage0.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 1:
                setContentView(R.layout.football);
                ImageView myImage1 = (ImageView) findViewById(R.id.imageView2);
                myImage1.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 2:
                setContentView(R.layout.badminton);
                ImageView myImage2 = (ImageView) findViewById(R.id.imageView2);
                myImage2.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 3:
                setContentView(R.layout.cricket);
                ImageView myImage3 = (ImageView) findViewById(R.id.imageView2);
                myImage3.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 4:
                setContentView(R.layout.hockey);
                ImageView myImage4 = (ImageView) findViewById(R.id.imageView2);
                myImage4.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 5:
                setContentView(R.layout.basketball);
                ImageView myImage5 = (ImageView) findViewById(R.id.imageView2);
                myImage5.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 6:
                setContentView(R.layout.carrom);
                ImageView myImage6 = (ImageView) findViewById(R.id.imageView2);
                myImage6.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 7:
                setContentView(R.layout.chess);
                ImageView myImage7 = (ImageView) findViewById(R.id.imageView2);
                myImage7.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 8:
                setContentView(R.layout.lawntennis);
                ImageView myImage8 = (ImageView) findViewById(R.id.imageView2);
                myImage8.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 9:
                setContentView(R.layout.tabletennis);
                ImageView myImage9 = (ImageView) findViewById(R.id.imageView2);
                myImage9.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 10:
                setContentView(R.layout.snooker);
                ImageView myImage10 = (ImageView) findViewById(R.id.imageView2);
                myImage10.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 11:
                setContentView(R.layout.kabaddi);
                ImageView myImage11 = (ImageView) findViewById(R.id.imageView2);
                myImage11.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 12:
                setContentView(R.layout.powerlifting);
                ImageView myImage12 = (ImageView) findViewById(R.id.imageView2);
                myImage12.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 13:
                setContentView(R.layout.volleyball);
                ImageView myImage13 = (ImageView) findViewById(R.id.imageView2);
                myImage13.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 14:
                setContentView(R.layout.ultimatefrisbee);
                ImageView myImage14 = (ImageView) findViewById(R.id.imageView2);
                myImage14.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;
            case 15:
                setContentView(R.layout.duathlon);
                ImageView myImage15 = (ImageView) findViewById(R.id.imageView2);
                myImage15.setImageResource(imageId);
                getSupportActionBar().setTitle(sportName);
                break;


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parallax__grid_item, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        //closing transition animations
        overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();
            return true;

            // NavUtils.navigateUpFromSameTask(this);
            // super.onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }
}
