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
public class DiscrollableYouTubeLayout extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollableYouTubeLayout";

    private View mYouTubeView1;
    private View mYouTubeView2;

    private float mYouTubeView1TranslationX;
    private float mYouTubeView2TranslationX;

    public DiscrollableYouTubeLayout(Context context) {
        super(context);
    }

    public DiscrollableYouTubeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollableYouTubeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mYouTubeView1 = findViewById(R.id.youTubeView1);
        mYouTubeView1TranslationX = mYouTubeView1.getTranslationX();
        mYouTubeView2 = findViewById(R.id.youTubeView2);
        mYouTubeView2TranslationX = mYouTubeView2.getTranslationX();
        mYouTubeView1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Cj5Ko8t4MeE&channel=UC7zmJovCGy9MqKmCtjL2hKw"));
                getContext().startActivity(browserYoutube);
            }
        });

    }

    @Override
    public void onDiscrollve(float ratio) {
        if (ratio <= 0.25f) {
            mYouTubeView2.setTranslationX(0);
            mYouTubeView2.setAlpha(0.0f);
            mYouTubeView1.setTranslationX(0);
            mYouTubeView1.setAlpha(0.0f);
            float rratio = ratio / 0.25f;
            mYouTubeView1.setTranslationX(mYouTubeView1TranslationX * (1 - rratio));
            mYouTubeView1.setAlpha(rratio);

            mYouTubeView2.setTranslationX(mYouTubeView2TranslationX * (1 - rratio));
            mYouTubeView2.setAlpha(rratio);
        } else {
            mYouTubeView1.setTranslationX(0);
            mYouTubeView1.setAlpha(1.0f);

            mYouTubeView2.setTranslationX(0);
            mYouTubeView2.setAlpha(1.0f);
            //float rratio = (ratio - 0.5f) / 0.5f;
            //mFbLikeView2.setTranslationX(mFbLikeView2TranslationX * (1 - rratio));
            //mFbLikeView2.setAlpha(rratio);
        }
    }

    @Override
    public void onResetDiscrollve() {

        mYouTubeView1.setAlpha(0);
        mYouTubeView2.setAlpha(0);
        mYouTubeView1.setTranslationX(mYouTubeView1TranslationX);
        mYouTubeView2.setTranslationX(mYouTubeView2TranslationX);

    }
}
