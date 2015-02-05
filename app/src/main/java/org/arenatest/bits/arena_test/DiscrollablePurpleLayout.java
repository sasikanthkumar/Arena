package org.arenatest.bits.arena_test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Sasikanth on 1/28/15.
 */
public class DiscrollablePurpleLayout extends LinearLayout implements Discrollvable {
    private static final String TAG = "DiscrollablePurpleLayout";
    private View mPurpleView1;
    private View mPurpleView2;

    private float mPurpleView1TranslationX;
    private float mPurpleView2TranslationX;

    private float mPurpleView1TranslationY;
    private float mPurpleView2TranslationY;

    public DiscrollablePurpleLayout(Context context) {
        super(context);
    }

    public DiscrollablePurpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public DiscrollablePurpleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mPurpleView1 = findViewById(R.id.purpleView1);
        mPurpleView1TranslationX = mPurpleView1.getTranslationX();
        mPurpleView1TranslationY = mPurpleView1.getTranslationY();

        mPurpleView2 = findViewById(R.id.purpleView2);
        mPurpleView2TranslationX = mPurpleView2.getTranslationX();
        mPurpleView2TranslationY = mPurpleView2.getTranslationY();
        mPurpleView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserAtmos = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bits.atmos?fref=ts"));
                getContext().startActivity(browserAtmos);
            }
        });
    }

    @Override
    public void onDiscrollve(float ratio) {

        /*
        if (ratio <= 0.25f) {
            mPurpleView2.setTranslationX(0);
            mPurpleView2.setAlpha(0.0f);
            float rratio = ratio / 0.25f;
            mPurpleView1.setTranslationX(mPurpleView1TranslationX * (1 - rratio));
            mPurpleView1.setAlpha(rratio);
        } else {
            mPurpleView1.setTranslationX(0);
            mPurpleView1.setAlpha(1.0f);
            float rratio = (ratio - 0.25f) / 0.25f;
            mPurpleView2.setTranslationX(mPurpleView2TranslationX * (1 - rratio));
            mPurpleView2.setAlpha(rratio);
        }*/
        if (ratio <= 0.25f) {
            mPurpleView2.setTranslationX(0);
            mPurpleView2.setTranslationY(0);

            mPurpleView2.setAlpha(0.0f);
            mPurpleView1.setTranslationX(0);
            mPurpleView1.setTranslationY(0);

            mPurpleView1.setAlpha(0.0f);
            float rratio = ratio / 0.25f;
            mPurpleView1.setTranslationX(mPurpleView1TranslationX * (1 - rratio));
            mPurpleView1.setTranslationY(mPurpleView1TranslationY * (1 - rratio));

            mPurpleView1.setAlpha(rratio);

            mPurpleView2.setTranslationX(mPurpleView2TranslationX * (1 - rratio));
            mPurpleView2.setTranslationY(mPurpleView2TranslationY * (1 - rratio));

            mPurpleView2.setAlpha(rratio);
        } else {
            mPurpleView1.setTranslationX(0);
            mPurpleView1.setTranslationY(0);

            mPurpleView1.setAlpha(1.0f);

            mPurpleView2.setTranslationX(0);
            mPurpleView2.setTranslationY(0);

            mPurpleView2.setAlpha(1.0f);
            //float rratio = (ratio - 0.5f) / 0.5f;
            //mFbLikeView2.setTranslationX(mFbLikeView2TranslationX * (1 - rratio));
            //mFbLikeView2.setAlpha(rratio);
        }

    }

    @Override
    public void onResetDiscrollve() {
        mPurpleView1.setAlpha(0);
        mPurpleView2.setAlpha(0);
        mPurpleView1.setTranslationX(mPurpleView1TranslationX);
        mPurpleView2.setTranslationX(mPurpleView2TranslationX);
        mPurpleView1.setTranslationY(mPurpleView1TranslationY);
        mPurpleView2.setTranslationY(mPurpleView2TranslationY);

    }
}
