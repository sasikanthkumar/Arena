package org.arenatest.bits.arena_test;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    RelativeLayout arena15rl, arena14rl, directorrl;
    CardView arena15, arena14, director;
    FloatingActionButton floatab;
    Boolean flagAbout = false;
    ImageView img1, img2, img;
    Bitmap bitmap, bitmap1, bitmap2;
    ListView listView;
    String[] NameList = {"Arena15", "Arena14", "From directer"};
    private GridViewAdapter myListAdapter;
    private ArrayList<ImageItem> data3 = new ArrayList<ImageItem>();


    public AboutFragment() {
        // Required empty public constructor
    }

    public void loadBitmap(int resId, ImageView imageView, Resources res) {
        //BitmapWorkerTask task = new BitmapWorkerTask(imageView, res);
        //task.execute(resId);
    }

    /*  private ArrayList<ImageItemAbout> getData() {
          final ArrayList<ImageItemAbout> imageItemsAbout = new ArrayList<ImageItemAbout>();
          // retrieve String drawable array
          TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids_about);
          for (int i = 0; i < imgs.length(); i++) {
              Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                      imgs.getResourceId(i, -1));
              imageItemsAbout.add(new ImageItemAbout(bitmap, NameList[i]));
          }

          return imageItemsAbout;

      }*/
  /*  public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ghg", "jjjj");
        View layout = inflater.inflate(R.layout.fragment_about, container, false);
        //arena15rl = (RelativeLayout) layout.findViewById(R.id.arena15rl);
        //arena14rl = (RelativeLayout) layout.findViewById(R.id.arena14rl);
        //directorrl = (RelativeLayout) layout.findViewById(R.id.directorrl);

        //floatab = (FloatingActionButton) layout.findViewById(R.id.floatab);
        //added

        //img1 = (ImageView) layout.findViewById(R.id.info_text1);
        //img2 = (ImageView) layout.findViewById(R.id.info_text2);
        //img = (ImageView) layout.findViewById(R.id.info_text);

        //img1.setImageBitmap(bitmap);
        //img2.setImageBitmap(bitmap1);
        //img.setImageBitmap(bitmap2);
        //loadBitmap(R.drawable.arena15, img1, getResources());
        //loadBitmap(R.drawable.arena14, img2, getResources());

        //loadBitmap(R.drawable.arena14, img, getResources());

        //floatab.setOnClickListener(this);
        //arena15rl.setOnClickListener(this);
        //arena14rl.setOnClickListener(this);
        //directorrl.setOnClickListener(this);
        return layout;
    }


    @Override
    public void onClick(View v) {
        if (!flagAbout) {
            flagAbout = true;
            Dialog d = new Dialog(v.getContext());
            d.getWindow().getAttributes().windowAnimations = R.style.dialog_animation_fade;
            d.setContentView(R.layout.dialog_aboutus);
            d.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    flagAbout = false;
                }
            });
            d.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    flagAbout = false;
                }
            });
            TextView aboutus_text = (TextView) d.findViewById(R.id.aboutus_text);
            switch (v.getId()) {
               /* case R.id.arena15rl:
                    d.setTitle("Arena 15");
                    aboutus_text.setText(R.string.aboutus_arena15);
                    d.show();
                    break;
                case R.id.arena14rl:
                    d.setTitle("Arena 14");
                    aboutus_text.setText(R.string.aboutus_arena14);
                    d.show();
                    break;
                case R.id.directorrl:
                    d.setTitle("From the Directors Desk");
                    aboutus_text.setText(R.string.aboutus_director);
                    d.show();
                    break;*/
                //case R.id.floatab:
                //Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/bits.arena"));
                //startActivity(intent);
                //flagAbout = false;
                //break;

            }
        }
    }
}


class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
    private int data = 0;
    private Resources resources;

    public BitmapWorkerTask(ImageView imageView, Resources resources) {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.resources = resources;
    }

    // Decode image in background.
    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return decodeSampleBitmapFromResource(resources, data, 200, 100);
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}