package org.arenatest.bits.arena_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.pushbots.push.Pushbots;

import java.util.HashMap;

/**
 * Created by Sasikanth on 1/23/15.
 */
public class CustomPushReciver extends BroadcastReceiver {
    private static final String TAG = "customPushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //Log.d(TAG, "action=" + action);
        // Handle Push Message when opened
        if (action.equals(Pushbots.MSG_OPENED)) {
            HashMap<?, ?> PushdataOpen = (HashMap<?, ?>) intent.getExtras().get(Pushbots.MSG_OPEN);
            //Log.w(TAG, "User clicked notification with Message: " + PushdataOpen.get("message"));
            // Start activity if not active
            // set the value of local variable "active" in onStart()/onStop() in MainActivity
            // to check for MainActivity status
            if (!MainActivity.isActive()) {
                Intent launch = new Intent(Intent.ACTION_MAIN);
                launch.setClass(Pushbots.getInstance().appContext, MainActivity.class);
                launch.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Pushbots.getInstance().appContext.startActivity(launch);
            }
            // Handle Push Message when received
        } else if (action.equals(Pushbots.MSG_RECEIVE)) {
            HashMap<?, ?> Pushdata = (HashMap<?, ?>) intent.getExtras().get(Pushbots.MSG_RECEIVE);
            //Log.w(TAG, "User Received notification with Message: " + Pushdata.get("message"));
        }
    }
}