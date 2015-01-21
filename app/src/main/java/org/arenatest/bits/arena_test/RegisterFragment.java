package org.arenatest.bits.arena_test;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends android.support.v4.app.Fragment {
private  Context context;

    public RegisterFragment(Context context) {
        // Required empty public constructor
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        WebView wv = (WebView) v.findViewById(R.id.registerWebview);
        wv.loadUrl("http://www.bits-arena.com/form.html");
        wv.setWebViewClient(new MyWebViewClient());

        return v;
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
