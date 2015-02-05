package org.arenatest.bits.arena_test;

import android.app.Application;

import com.pushbots.push.Pushbots;

/**
 * Created by Sasikanth on 1/23/15.
 */
public class MyApplication extends Application {
    private String SENDER_ID = "698688446618";
    private String PUSHBOTS_APPLICATION_ID = "54c226e81d0ab1d6328b46c3";

    @Override
    public void onCreate() {
        super.onCreate();
        Pushbots.init(this, SENDER_ID, PUSHBOTS_APPLICATION_ID);
        Pushbots.getInstance().setMsgReceiver(CustomPushReciver.class);

    }
}
