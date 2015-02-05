package org.arenatest.bits.arena_test;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdatesFragment extends ListFragment {

    private ProgressDialog pDialog;
    private String dataPath;
    FloatingActionButton refresh;
    JSONParser jParser = new JSONParser();
    ArrayList<HashMap<String, String>> updatesList;
    // url to get all updates list
    private static String url_all_updates = "http://bits-pearl.org/arena_connect/get_all_updates.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_UPDATES = "updates";
    private static final String TAG_UID = "uid";
    private static final String TAG_MAIN_TITLE = "main_title";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG_SUB_TITLE = "sub_title";

    // updates JSONArray
    JSONArray updates = null;
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public UpdatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vUpdates = inflater.inflate(R.layout.fragment_updates, container, false);
        refresh = (FloatingActionButton) vUpdates.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, new UpdatesFragment());
                ft.commit();

                //Toast.makeText(getActivity(), "sss", Toast.LENGTH_LONG).show();
            }
        });
        return vUpdates;

    }

    private void savePrefs(String key, String value) {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }

    private void loadPrefs() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        dataPath = sp.getString("DATAPATH", "");

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updatesList = new ArrayList<HashMap<String, String>>();
        lv = getListView();
        refresh.attachToListView(lv);
        ObjectToFileUtil test3 = new ObjectToFileUtil();

        // Loading updates in Background Thread
        if (isNetworkAvailable()) {
            new LoadAllProducts().execute();
        } else {
            try {
                loadPrefs();
                updatesList = (ArrayList<HashMap<String, String>>) test3.objectFromFile(dataPath);
                if (updatesList == null) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Check your Internet Connection");
                    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Intent positiveActivity = new Intent(AllUpdatesActivity.this, MainActivity.class);
                            //positiveActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            //startActivity(positiveActivity);
                            //finish();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } else {
                    ListAdapter adapter = new SimpleAdapter(
                            getActivity(), updatesList,
                            R.layout.list_item_updates, new String[]{TAG_UID,
                            TAG_MAIN_TITLE, TAG_SUB_TITLE, TAG_MESSAGE},
                            new int[]{R.id.uid, R.id.main_title, R.id.sub_title, R.id.msg});
                    // updating listview
                    setListAdapter(adapter);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    class LoadAllProducts extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Loading updates. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }


        /**
         * getting All updates from url
         */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all_updates, "GET", params);

            // Check your log cat for JSON reponse
            //Log.d("All Products: ", json.toString());
            if (json != null) {
                try {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        // updates found
                        // Getting Array of Products
                        updates = json.getJSONArray(TAG_UPDATES);

                        // looping through All Products
                        for (int i = 0; i < updates.length(); i++) {
                            JSONObject c = updates.getJSONObject(i);

                            // Storing each json item in variable
                            String id = c.getString(TAG_UID);
                            String main_title = c.getString(TAG_MAIN_TITLE);
                            String sub_title = c.getString(TAG_SUB_TITLE);

                            String message = c.getString(TAG_MESSAGE);


                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            map.put(TAG_UID, id);
                            map.put(TAG_MAIN_TITLE, main_title);
                            map.put(TAG_SUB_TITLE, sub_title);

                            map.put(TAG_MESSAGE, message);


                            // adding HashList to ArrayList
                            updatesList.add(map);
                        }
                    } else {
                        // no updates found
                        // Launch Add New product Activity
                        //Intent i = new Intent(getApplicationContext(),
                        //NewProductActivity.class);
                        // Closing all previous activities
                        //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //startActivity(i);
                        //Log.d("sss", "aaa");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                //Log.d("aaa", "aaa");
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all updates
            ObjectToFileUtil test4 = new ObjectToFileUtil();

            pDialog.dismiss();
            try {
                dataPath = test4.objectToFile(updatesList);
                savePrefs("DATAPATH", dataPath);
                //Toast.makeText(getActivity(), "stored", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // updating UI from Background Thread
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                            getActivity(), updatesList,
                            R.layout.list_item_updates, new String[]{TAG_UID,
                            TAG_MAIN_TITLE, TAG_SUB_TITLE, TAG_MESSAGE},
                            new int[]{R.id.uid, R.id.main_title, R.id.sub_title, R.id.msg});
                    // updating listview
                    setListAdapter(adapter);
                }
            });

        }

    }
}

