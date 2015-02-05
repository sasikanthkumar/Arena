package org.arenatest.bits.arena_test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Sasikanth on 1/28/15.
 */
public class DiscrollableRedLayout extends FrameLayout implements Discrollvable {
    private static final String TAG = "DiscrollableRedLayout";
    private View mRedView1;
    private View mRedView2;

    private float mRedView1TranslationY;

    public DiscrollableRedLayout(Context context) {
        super(context);
    }

    public DiscrollableRedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollableRedLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mRedView1 = findViewById(R.id.redView1);
        mRedView1TranslationY = mRedView1.getTranslationY();
        mRedView2 = findViewById(R.id.redView2);
        mRedView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserPearl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bitspearl?fref=ts"));
                getContext().startActivity(browserPearl);
            }
        });
    }

    @Override
    public void onDiscrollve(float ratio) {
        if (ratio <= 0.25f) {
            mRedView1.setTranslationY(-1 * (mRedView1.getHeight() / 1.5f) * (ratio / 0.25f));
        } else {
            float rratio = (ratio - 0.25f) / 0.25f;
            rratio = Math.min(rratio, 1.0f);
            mRedView1.setTranslationY(-1 * (mRedView1.getHeight() / 1.5f));
            mRedView2.setAlpha(1 * rratio);
            mRedView2.setScaleX(1.0f * rratio);
            mRedView2.setScaleY(1.0f * rratio);
        }

    }

    @Override
    public void onResetDiscrollve() {

    }
}
