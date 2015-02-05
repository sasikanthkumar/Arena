package org.arenatest.bits.arena_test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by Sasikanth on 1/28/15.
 */
public class DiscrollableFbLikeLayout extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollableFbLikeLayout";

    private View mFbLikeView1;
    private View mFbLikeView2;

    private float mFbLikeView1TranslationX;
    private float mFbLikeView2TranslationX;


    public DiscrollableFbLikeLayout(Context context) {
        super(context);
    }

    public DiscrollableFbLikeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public DiscrollableFbLikeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mFbLikeView1 = findViewById(R.id.fbLikeView1);
        mFbLikeView1TranslationX = mFbLikeView1.getTranslationX();

        mFbLikeView2 = findViewById(R.id.fbLikeView2);
        mFbLikeView2TranslationX = mFbLikeView2.getTranslationX();
        mFbLikeView1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserFb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bits.arena"));
                getContext().startActivity(browserFb);
            }
        });
    }

    @Override
    public void onDiscrollve(float ratio) {
        if (ratio <= 0.25f) {
            mFbLikeView2.setTranslationX(0);
            mFbLikeView2.setAlpha(0.0f);
            mFbLikeView1.setTranslationX(0);
            mFbLikeView1.setAlpha(0.0f);
            float rratio = ratio / 0.25f;
            mFbLikeView1.setTranslationX(mFbLikeView1TranslationX * (1 - rratio));
            mFbLikeView1.setAlpha(rratio);

            mFbLikeView2.setTranslationX(mFbLikeView2TranslationX * (1 - rratio));
            mFbLikeView2.setAlpha(rratio);
        } else {
            mFbLikeView1.setTranslationX(0);
            mFbLikeView1.setAlpha(1.0f);

            mFbLikeView2.setTranslationX(0);
            mFbLikeView2.setAlpha(1.0f);
            //float rratio = (ratio - 0.5f) / 0.5f;
            //mFbLikeView2.setTranslationX(mFbLikeView2TranslationX * (1 - rratio));
            //mFbLikeView2.setAlpha(rratio);
        }
    }

    @Override
    public void onResetDiscrollve() {
        mFbLikeView1.setAlpha(0);
        mFbLikeView2.setAlpha(0);
        mFbLikeView1.setTranslationX(mFbLikeView1TranslationX);
        mFbLikeView2.setTranslationX(mFbLikeView2TranslationX);
    }
}
