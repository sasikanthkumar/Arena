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
public class DiscrollableVmLayout extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollableVmLayout";
    private View mVmView1;
    private View mVmView2;

    private float mVmView1TranslationX;
    private float mVmView2TranslationX;

    private float mVmView1TranslationY;
    private float mVmView2TranslationY;


    public DiscrollableVmLayout(Context context) {
        super(context);
    }

    public DiscrollableVmLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollableVmLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mVmView1 = findViewById(R.id.vmView1);
        mVmView1TranslationX = mVmView1.getTranslationX();
        mVmView1TranslationY = mVmView1.getTranslationY();

        mVmView2 = findViewById(R.id.vmView2);
        mVmView2TranslationX = mVmView2.getTranslationX();
        mVmView2TranslationY = mVmView2.getTranslationY();
        mVmView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserVm = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/verbamaximus?fref=ts"));
                getContext().startActivity(browserVm);
            }
        });
    }

    @Override
    public void onDiscrollve(float ratio) {

        if (ratio <= 0.25f) {
            mVmView2.setTranslationX(0);
            mVmView2.setTranslationY(0);
            mVmView2.setAlpha(0.0f);

            mVmView1.setTranslationX(0);
            mVmView1.setTranslationY(0);
            mVmView1.setAlpha(0.0f);

            float rratio = ratio / 0.25f;

            mVmView1.setTranslationX(mVmView1TranslationX * (1 - rratio));
            mVmView1.setTranslationY(mVmView1TranslationY * (1 - rratio));

            mVmView1.setAlpha(rratio);

            mVmView2.setTranslationX(mVmView2TranslationX * (1 - rratio));
            mVmView2.setTranslationY(mVmView2TranslationY * (1 - rratio));

            mVmView2.setAlpha(rratio);
        } else {
            mVmView1.setTranslationX(0);
            mVmView1.setTranslationY(0);

            mVmView1.setAlpha(1.0f);

            mVmView2.setTranslationX(0);
            mVmView2.setTranslationY(0);

            mVmView2.setAlpha(1.0f);

        }

    }

    @Override
    public void onResetDiscrollve() {
        mVmView1.setAlpha(0);
        mVmView2.setAlpha(0);
        mVmView1.setTranslationX(mVmView1TranslationX);
        mVmView2.setTranslationX(mVmView2TranslationX);
        mVmView1.setTranslationY(mVmView1TranslationY);
        mVmView2.setTranslationY(mVmView2TranslationY);
    }
}
