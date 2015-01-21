package org.arenatest.bits.arena_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.manuelpeinado.fadingactionbar.extras.actionbarcompat.FadingActionBarHelper;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Random;


public class Parallax_GridItem extends ActionBarActivity {
    String sportName;
    int imageId;
    int position;
    private float mactionBarHeight;
    private android.support.v7.app.ActionBar actionBar;
    //private DisplayImageOptions options1;
    //private ImageLoader imageLoader1;
    private ViewGroup viewGroup;
    Random random = new Random();
    int colorPosition;
    String ActionBarColors[];
    String StatusBarColors[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        /*options1 = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_drawer_aboutus)
                .showImageForEmptyUri(R.drawable.ic_drawer_aboutus)
                .showImageOnFail(R.drawable.ic_drawer_aboutus)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        imageLoader1 = ImageLoader.getInstance();
        imageLoader1.init(ImageLoaderConfiguration.createDefault(this));*/
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        ActionBarColors = getResources().getStringArray(R.array.ActionBarColors);
        StatusBarColors = getResources().getStringArray(R.array.StatusBarColors);
        //added
        //setContentView(R.layout.common_parallax);

        //added
        colorPosition = random.nextInt(10);


        try {


            //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(ActionBarColors[colorPosition])));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                getWindow().setStatusBarColor(Color.parseColor(StatusBarColors[colorPosition]));

        } catch (Exception e) {
            e.printStackTrace();

        }

        //getSupportActionBar().setHomeButtonEnabled(true);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null) {

            //imageId = intent.getIntExtra("sportImage", R.drawable.athletics);
            sportName = intent.getStringExtra("sportName");
            position = intent.getIntExtra("Position", 0);


        }
        switch (position) {
            case 0:

                //setContentView(R.layout.athletics);
                //ImageView myImage0 = (ImageView) findViewById(R.id.imageView2);
                //myImage0.setImageResource(imageId);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.athletics_two, myImage0);
                //getSupportActionBar().setTitle(sportName);
                FadingActionBarHelper helper = new FadingActionBarHelper()
                        .actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header)
                        .contentLayout(R.layout.athletics);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                //TextView eventManagers1 = (TextView) findViewById(R.id.eventManagers1);
                //eventManagers1.setTextColor(Color.parseColor(ActionBarColors[colorPosition]));
                break;
            case 1:
                setContentView(R.layout.football);
                //ImageView myImage1 = (ImageView) findViewById(R.id.imageView2);
                //myImage1.setImageResource(imageId);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.football_one, myImage1);

                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers2)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));


                break;
            case 2:
                setContentView(R.layout.badminton);
                //ImageView myImage2 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.badminton_one, myImage2);

                //myImage2.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers3)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 3:
                setContentView(R.layout.cricket);
                //ImageView myImage3 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.cricket_one, myImage3);

                //myImage3.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers4)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 4:
                setContentView(R.layout.hockey);
                //ImageView myImage4 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.hockey_one, myImage4);

                //myImage4.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers5)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 5:
                setContentView(R.layout.basketball);
                //ImageView myImage5 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.basketball_one, myImage5);

                //myImage5.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers6)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 6:
                setContentView(R.layout.carrom);
                //ImageView myImage6 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.carroms_one, myImage6);

                //myImage6.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers7)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 7:
                setContentView(R.layout.chess);
                //ImageView myImage7 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.chess_one, myImage7);

                //myImage7.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers8)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 8:
                setContentView(R.layout.lawntennis);
                //ImageView myImage8 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.tennis_one, myImage8);

                //myImage8.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers9)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 9:
                setContentView(R.layout.tabletennis);
                //ImageView myImage9 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.table_tennis_one, myImage9);

                //myImage9.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers10)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 10:
                setContentView(R.layout.snooker);
                //ImageView myImage10 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.snooker_one, myImage10);

                //myImage10.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                //((TextView) findViewById(R.id.eventManagers11)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 11:
                setContentView(R.layout.kabaddi);
                //ImageView myImage11 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.kabaddi_one, myImage11);

                //myImage11.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                //((TextView) findViewById(R.id.eventManagers12)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 12:
                setContentView(R.layout.powerlifting);
                //ImageView myImage12 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.power_lifting_one, myImage12);

                //myImage12.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers13)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 13:
                setContentView(R.layout.volleyball);
                //ImageView myImage13 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.volleyball_o, myImage13);

                //myImage13.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                ((TextView) findViewById(R.id.eventManagers14)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 14:
                setContentView(R.layout.ultimatefrisbee);
                //ImageView myImage14 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.throw_ball, myImage14);

                //myImage14.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                // ((TextView) findViewById(R.id.eventManagers15)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            case 15:
                setContentView(R.layout.duathlon);
                //ImageView myImage15 = (ImageView) findViewById(R.id.imageView2);
                //imageLoader1.getInstance().displayImage("drawable://" + R.drawable.duathlon_two, myImage15);

                //myImage15.setImageResource(imageId);
                //getSupportActionBar().setTitle(sportName);
                //((TextView) findViewById(R.id.eventManagers16)).setTextColor(Color.parseColor(ActionBarColors[colorPosition]));

                break;
            default:
                Toast.makeText(this, "default", Toast.LENGTH_LONG).show();

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
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

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
