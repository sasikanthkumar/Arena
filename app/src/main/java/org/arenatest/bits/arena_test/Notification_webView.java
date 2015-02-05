package org.arenatest.bits.arena_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Notification_webView extends ActionBarActivity {
    WebView webNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("NotificationLinks");
        setContentView(R.layout.activity_notification_web_view);
        webNotification = (WebView) findViewById(R.id.webViewNotification);
        webNotification.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("url");
        webNotification.getSettings().setBuiltInZoomControls(true);
        webNotification.getSettings().setSupportZoom(true);
        webNotification.getSettings().setUseWideViewPort(true);
        webNotification.getSettings().setLoadWithOverviewMode(true);
        webNotification.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Notification_webView.this, MainActivity.class);
        startActivity(intent);
    }
}
