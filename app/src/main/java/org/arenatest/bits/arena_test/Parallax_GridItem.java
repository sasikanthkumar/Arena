package org.arenatest.bits.arena_test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.manuelpeinado.fadingactionbar.extras.actionbarcompat.FadingActionBarHelper;

import java.util.Random;


public class Parallax_GridItem extends ActionBarActivity {
    String sportName;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);


        Intent intent = getIntent();
        if (intent != null) {

            sportName = intent.getStringExtra("sportName");
            position = intent.getIntExtra("Position", 0);


        }
        FadingActionBarHelper helper = new FadingActionBarHelper();

        ActionBar bar = getSupportActionBar();
        bar.setTitle(sportName);

        switch (position) {
            case 0:

                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_athletics)
                        .contentLayout(R.layout.athletics);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 1:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_football)
                        .contentLayout(R.layout.football);
                setContentView(helper.createView(this));
                helper.initActionBar(this);


                break;
            case 2:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_badminton)
                        .contentLayout(R.layout.badminton);
                setContentView(helper.createView(this));
                helper.initActionBar(this);

                break;
            case 3:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_cricket)
                        .contentLayout(R.layout.cricket);
                setContentView(helper.createView(this));
                helper.initActionBar(this);

                break;
            case 4:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_hockey)
                        .contentLayout(R.layout.hockey);
                setContentView(helper.createView(this));
                helper.initActionBar(this);

                break;
            case 5:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_basketball)
                        .contentLayout(R.layout.basketball);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 6:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_carrom)
                        .contentLayout(R.layout.carrom);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 7:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_chess)
                        .contentLayout(R.layout.chess);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 8:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_lawntennis)
                        .contentLayout(R.layout.lawntennis);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 9:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_tabletennis)
                        .contentLayout(R.layout.tabletennis);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 10:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_snooker)
                        .contentLayout(R.layout.snooker);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 11:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_kabaddi)
                        .contentLayout(R.layout.kabaddi);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 12:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_powerlifting)
                        .contentLayout(R.layout.powerlifting);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 13:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_volleyball)
                        .contentLayout(R.layout.volleyball);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 14:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_throwball)
                        .contentLayout(R.layout.throwball);
                setContentView(helper.createView(this));
                helper.initActionBar(this);
                break;
            case 15:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_duathlon)
                        .contentLayout(R.layout.duathlon);
                setContentView(helper.createView(this));
                helper.initActionBar(this);

                break;
            default:
                Toast.makeText(this, "default", Toast.LENGTH_LONG).show();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (position == 15) {
            getMenuInflater().inflate(R.menu.menu_parallax__grid_item, menu);
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Dialog dialogLicenses = new Dialog(this);
            dialogLicenses.getWindow().setLayout(100, 100);
            dialogLicenses.setContentView(R.layout.dialog_licenses);
            dialogLicenses.setTitle("OpenSource Licenses");
            dialogLicenses.show();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
