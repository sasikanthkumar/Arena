package org.arenatest.bits.arena_test;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.*;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends android.support.v4.app.Fragment {

    private GoogleMap map;
    private static View view;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        try {
            view = inflater.inflate(R.layout.fragment_maps, container, false);

            map = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
            LatLng latlng = new LatLng(17.54486D, 78.571718000000004D);
            map.addMarker(new MarkerOptions().position(latlng).title("BPHC"));
            final LatLng latlng1 = new LatLng(17.544695999999998D, 78.570898999999997D);
            LatLng latlng2 = new LatLng(17.545203000000001D, 78.571393D);
            LatLng latlng3 = new LatLng(17.544074999999999D, 78.573763999999997D);
            LatLng latlng4 = new LatLng(17.540624999999999D, 78.575293000000002D);
            map.addMarker((new MarkerOptions()).position(latlng1).title("Uninor LTC"));
            map.addMarker((new MarkerOptions()).position(latlng2).title("SBH STAGE 1"));
            map.addMarker((new MarkerOptions()).position(latlng3).title("Imagine Canada STAGE 2"));
            map.addMarker((new MarkerOptions()).position(latlng4).title("Beam SAC"));
            com.google.android.gms.maps.CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(latlng);
            com.google.android.gms.maps.CameraUpdate cameraUpdate1 = CameraUpdateFactory.zoomTo(18F);
            map.moveCamera(cameraUpdate);
            map.animateCamera(cameraUpdate1);
            map.setMyLocationEnabled(true);

        } catch (Exception e) {
            //Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }
        return view;
    }


}



