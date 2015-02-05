package org.arenatest.bits.arena_test;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RegisterFragment extends android.support.v4.app.Fragment {
    WebView webReg;

    public RegisterFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View regView = inflater.inflate(R.layout.fragment_register, container, false);
        webReg = (WebView) regView.findViewById(R.id.webViewReg);
        webReg.setWebViewClient(new WebViewClient());
        String url = "https://docs.google.com/forms/d/1teThiUsH2MwwF2AdDMGuhyPXiaHBhXbNBKM7AM0xDfQ/viewform?c=0&w=1";
        webReg.getSettings().setBuiltInZoomControls(true);
        webReg.getSettings().setSupportZoom(true);
        webReg.getSettings().setUseWideViewPort(true);
        webReg.getSettings().setLoadWithOverviewMode(true);
        webReg.loadUrl(url);

        return regView;

    }
}