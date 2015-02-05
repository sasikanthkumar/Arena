package org.arenatest.bits.arena_test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
        Typeface tfMatter = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Bold.ttf");
        Typeface tfMatter2 = Typeface.createFromAsset(this.getAssets(), "fonts/Oswald-Regular.ttf");

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
                TextView trackEvents = (TextView) findViewById(R.id.trackEvents);
                TextView rulesAthletics = (TextView) findViewById(R.id.rulesAthletics);
                rulesAthletics.setTypeface(tfMatter, Typeface.ITALIC);
                trackEvents.setTypeface(tfMatter, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 1:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_football)
                        .contentLayout(R.layout.football);
                setContentView(helper.createView(this));
                TextView rulesFootball = (TextView) findViewById(R.id.rulesFootball);
                TextView groupStage = (TextView) findViewById(R.id.groupStage);
                TextView eventMangers2 = (TextView) findViewById(R.id.eventManagers2);
                TextView shantanu = (TextView) findViewById(R.id.shubhamBharadwaj);
                TextView shantanuPhone = (TextView) findViewById(R.id.shubhamBharadwajPhone);
                shantanu.setTypeface(tfMatter2, Typeface.ITALIC);
                shantanuPhone.setTypeface(tfMatter2, Typeface.ITALIC);
                eventMangers2.setTypeface(tfMatter, Typeface.ITALIC);
                groupStage.setTypeface(tfMatter, Typeface.ITALIC);
                rulesFootball.setTypeface(tfMatter, Typeface.ITALIC);
                helper.initActionBar(this);


                break;
            case 2:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_badminton)
                        .contentLayout(R.layout.badminton);
                setContentView(helper.createView(this));
                TextView rulesForMen = (TextView) findViewById(R.id.rulesForMen);
                TextView rulesForWomen = (TextView) findViewById(R.id.rulesForWomen);
                TextView balusai = (TextView) findViewById(R.id.baluSai);
                TextView balusaiPhn = (TextView) findViewById(R.id.baluSaiPhone);
                TextView kcs = (TextView) findViewById(R.id.kcs);
                TextView kcsPhn = (TextView) findViewById(R.id.kcsPhone);
                TextView eventMan3 = (TextView) findViewById(R.id.eventManagers3);
                eventMan3.setTypeface(tfMatter2, Typeface.ITALIC);
                balusai.setTypeface(tfMatter2, Typeface.ITALIC);
                balusaiPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                kcs.setTypeface(tfMatter2, Typeface.ITALIC);
                kcsPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                rulesForWomen.setTypeface(tfMatter, Typeface.ITALIC);
                rulesForMen.setTypeface(tfMatter, Typeface.ITALIC);
                helper.initActionBar(this);

                break;
            case 3:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_cricket)
                        .contentLayout(R.layout.cricket);
                setContentView(helper.createView(this));
                TextView rulesCric = (TextView) findViewById(R.id.rulesCric);
                rulesCric.setTypeface(tfMatter, Typeface.ITALIC);
                TextView kaka = (TextView) findViewById(R.id.kaka);

                TextView kakaPhn = (TextView) findViewById(R.id.kakaPhone);
                TextView harsh = (TextView) findViewById(R.id.harsh);
                TextView harshPhn = (TextView) findViewById(R.id.harshPhone);
                TextView eventMangers4 = (TextView) findViewById(R.id.eventManagers4);
                eventMangers4.setTypeface(tfMatter2, Typeface.ITALIC);
                kaka.setTypeface(tfMatter2, Typeface.ITALIC);
                kakaPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                harsh.setTypeface(tfMatter2, Typeface.ITALIC);
                harshPhn.setTypeface(tfMatter2, Typeface.ITALIC);

                helper.initActionBar(this);

                break;
            case 4:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_hockey)
                        .contentLayout(R.layout.hockey);
                setContentView(helper.createView(this));
                TextView compOfTeams = (TextView) findViewById(R.id.compOfTeams);
                compOfTeams.setTypeface(tfMatter, Typeface.ITALIC);

                TextView matchTime = (TextView) findViewById(R.id.matchTime);
                matchTime.setTypeface(tfMatter, Typeface.ITALIC);
                TextView substitution = (TextView) findViewById(R.id.substitution);
                substitution.setTypeface(tfMatter, Typeface.ITALIC);
                TextView startAndRestart = (TextView) findViewById(R.id.startAndRestart);
                startAndRestart.setTypeface(tfMatter, Typeface.ITALIC);
                TextView centrePass = (TextView) findViewById(R.id.centerPass);
                centrePass.setTypeface(tfMatter, Typeface.ITALIC);
                TextView advantage = (TextView) findViewById(R.id.advantage);
                advantage.setTypeface(tfMatter, Typeface.ITALIC);
                TextView freeHit = (TextView) findViewById(R.id.freeHit);
                freeHit.setTypeface(tfMatter, Typeface.ITALIC);
                TextView penaltyCorner = (TextView) findViewById(R.id.penalty);
                penaltyCorner.setTypeface(tfMatter, Typeface.ITALIC);
                TextView penaltyStroke = (TextView) findViewById(R.id.penaltyStroke);
                penaltyStroke.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMangers5 = (TextView) findViewById(R.id.eventManagers5);
                eventMangers5.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView likith = (TextView) findViewById(R.id.likhith);
                TextView likithPhn = (TextView) findViewById(R.id.likhithPhn);
                likith.setTypeface(tfMatter2, Typeface.ITALIC);
                likithPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView eachMay = (TextView) findViewById(R.id.eachTeamMay);
                eachMay.setTypeface(tfMatter, Typeface.ITALIC);
                TextView coinTossed = (TextView) findViewById(R.id.coinIsTossed);
                coinTossed.setTypeface(tfMatter, Typeface.ITALIC);
                helper.initActionBar(this);

                break;
            case 5:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_basketball)
                        .contentLayout(R.layout.basketball);
                setContentView(helper.createView(this));
                TextView rulesBasket = (TextView) findViewById(R.id.rulesBasketball);
                rulesBasket.setTypeface(tfMatter, Typeface.ITALIC);
                TextView rishab = (TextView) findViewById(R.id.rishab);
                TextView rishbPhn = (TextView) findViewById(R.id.rishabPhone);
                TextView meha = (TextView) findViewById(R.id.meha);
                TextView mehaPhn = (TextView) findViewById(R.id.mehaPhn);
                rishab.setTypeface(tfMatter2, Typeface.ITALIC);
                rishbPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                meha.setTypeface(tfMatter2, Typeface.ITALIC);
                mehaPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView eventMangers6 = (TextView) findViewById(R.id.eventManagers6);
                eventMangers6.setTypeface(tfMatter2, Typeface.ITALIC);

                helper.initActionBar(this);
                break;
            case 6:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_carrom)
                        .contentLayout(R.layout.carrom);
                setContentView(helper.createView(this));
                TextView rulesCarrom = (TextView) findViewById(R.id.rulesCarrom);
                rulesCarrom.setTypeface(tfMatter, Typeface.ITALIC);
                TextView patil = (TextView) findViewById(R.id.patil);
                TextView patilPhn = (TextView) findViewById(R.id.patilPhn);
                patil.setTypeface(tfMatter2, Typeface.ITALIC);
                patilPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView eventMangers7 = (TextView) findViewById(R.id.eventManagers7);
                eventMangers7.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 7:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_chess)
                        .contentLayout(R.layout.chess);
                setContentView(helper.createView(this));
                TextView rulesChess = (TextView) findViewById(R.id.rulesChess);
                TextView rulesLight = (TextView) findViewById(R.id.rulesChessLight);
                TextView eventMan8 = (TextView) findViewById(R.id.eventManagers8);
                TextView eventsChess = (TextView) findViewById(R.id.eventsChess);
                eventsChess.setTypeface(tfMatter, Typeface.ITALIC);
                rulesChess.setTypeface(tfMatter, Typeface.ITALIC);
                rulesLight.setTypeface(tfMatter, Typeface.ITALIC);
                eventMan8.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView bharath = (TextView) findViewById(R.id.bharat);
                TextView bharatPhn = (TextView) findViewById(R.id.bharatPhn);
                TextView phani = (TextView) findViewById(R.id.phani);
                TextView phaniphn = (TextView) findViewById(R.id.phaniPhn);
                bharath.setTypeface(tfMatter2, Typeface.ITALIC);
                bharatPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                phani.setTypeface(tfMatter2, Typeface.ITALIC);
                phaniphn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 8:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_lawntennis)
                        .contentLayout(R.layout.lawntennis);
                setContentView(helper.createView(this));

                TextView rulesLawn = (TextView) findViewById(R.id.rulesLawnTennis);
                rulesLawn.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMan9 = (TextView) findViewById(R.id.eventManagers9);
                TextView vishal = (TextView) findViewById(R.id.vishal);
                TextView vishlPhn = (TextView) findViewById(R.id.vishalPhn);
                eventMan9.setTypeface(tfMatter2, Typeface.ITALIC);
                vishal.setTypeface(tfMatter2, Typeface.ITALIC);
                vishlPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 9:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_tabletennis)
                        .contentLayout(R.layout.tabletennis);
                setContentView(helper.createView(this));
                TextView rulesBoysTt = (TextView) findViewById(R.id.tTBoys);
                rulesBoysTt.setTypeface(tfMatter, Typeface.ITALIC);
                TextView rulesGirlsTt = (TextView) findViewById(R.id.tTGirls);
                rulesGirlsTt.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMan10 = (TextView) findViewById(R.id.eventManagers10);
                eventMan10.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView kansik = (TextView) findViewById(R.id.kansik);
                TextView kansikPhn = (TextView) findViewById(R.id.kansikPhn);
                TextView shriya = (TextView) findViewById(R.id.shriya);
                TextView shriyaPhn = (TextView) findViewById(R.id.sriyaPhn);
                kansik.setTypeface(tfMatter2, Typeface.ITALIC);
                kansikPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                shriya.setTypeface(tfMatter2, Typeface.ITALIC);
                shriyaPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 10:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_snooker)
                        .contentLayout(R.layout.snooker);
                setContentView(helper.createView(this));

                TextView rulesSnooker = (TextView) findViewById(R.id.rulesSnooker);
                rulesSnooker.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMan11 = (TextView) findViewById(R.id.eventManagers11);
                eventMan11.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView moturi = (TextView) findViewById(R.id.moturi);
                TextView moturiPhn = (TextView) findViewById(R.id.moturiPhn);
                TextView abhilash = (TextView) findViewById(R.id.abhilash);
                TextView abhilashPhn = (TextView) findViewById(R.id.abhilashPhn);
                moturi.setTypeface(tfMatter2, Typeface.ITALIC);
                moturiPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                abhilash.setTypeface(tfMatter2, Typeface.ITALIC);
                abhilashPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);

                break;
            case 11:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_kabaddi)
                        .contentLayout(R.layout.kabaddi);
                setContentView(helper.createView(this));
                TextView eventMan12 = (TextView) findViewById(R.id.eventManagers12);
                eventMan12.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView ranjith = (TextView) findViewById(R.id.ranjith);
                ranjith.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView ranjithPhn = (TextView) findViewById(R.id.ranjithPhn);
                ranjithPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 12:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_powerlifting)
                        .contentLayout(R.layout.powerlifting);
                setContentView(helper.createView(this));

                TextView rulesMenPower = (TextView) findViewById(R.id.rulesPowerLifting);
                rulesMenPower.setTypeface(tfMatter, Typeface.ITALIC);
                TextView fouls = (TextView) findViewById(R.id.foulsPowerLifting);
                fouls.setTypeface(tfMatter, Typeface.ITALIC);
                TextView squat = (TextView) findViewById(R.id.squat);
                squat.setTypeface(tfMatter, Typeface.ITALIC);
                TextView benchPres = (TextView) findViewById(R.id.benchPress);
                benchPres.setTypeface(tfMatter, Typeface.ITALIC);
                TextView dead = (TextView) findViewById(R.id.deadLift);
                dead.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMAn13 = (TextView) findViewById(R.id.eventManagers13);
                eventMAn13.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView lenka = (TextView) findViewById(R.id.lenka);
                TextView lenkaPhn = (TextView) findViewById(R.id.lenkaPhn);
                lenka.setTypeface(tfMatter2, Typeface.ITALIC);
                lenkaPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 13:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_volleyball)
                        .contentLayout(R.layout.volleyball);
                setContentView(helper.createView(this));
                TextView rulesVolley = (TextView) findViewById(R.id.rulesVolley);
                rulesVolley.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMan14 = (TextView) findViewById(R.id.eventManagers14);
                eventMan14.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView swayam = (TextView) findViewById(R.id.swayam);
                swayam.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView swayamPhn = (TextView) findViewById(R.id.swayamPhn);
                swayamPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView chaitanya = (TextView) findViewById(R.id.chaitanya);
                chaitanya.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView chaitPhn = (TextView) findViewById(R.id.chaitanyaPhn);
                chaitPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView subhi = (TextView) findViewById(R.id.subhi);
                subhi.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView subhiPhn = (TextView) findViewById(R.id.subhiPhn);
                subhiPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 14:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_throwball)
                        .contentLayout(R.layout.throwball);
                setContentView(helper.createView(this));
                TextView ruleThrow = (TextView) findViewById(R.id.rulesThrow);
                ruleThrow.setTypeface(tfMatter, Typeface.ITALIC);
                TextView eventMan15 = (TextView) findViewById(R.id.eventManagers15);
                eventMan15.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView prasanna = (TextView) findViewById(R.id.prasanna);
                prasanna.setTypeface(tfMatter2, Typeface.ITALIC);
                TextView prasannaPhn = (TextView) findViewById(R.id.prasannaPhn);
                prasannaPhn.setTypeface(tfMatter2, Typeface.ITALIC);
                helper.initActionBar(this);
                break;
            case 15:
                helper.actionBarBackground(R.drawable.ab_background)
                        .headerLayout(R.layout.header_duathlon)
                        .contentLayout(R.layout.duathlon);
                setContentView(helper.createView(this));
                TextView ruleDuath = (TextView) findViewById(R.id.rulesDuathlon);
                ruleDuath.setTypeface(tfMatter, Typeface.ITALIC);
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
