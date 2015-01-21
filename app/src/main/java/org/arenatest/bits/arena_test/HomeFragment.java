package org.arenatest.bits.arena_test;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeFragment extends android.support.v4.app.Fragment {
    private GridView myGridHome;
    private ViewPager pager;
    private GridViewAdapter myAdapter;

    private ActionBar actionBar;
    private ArrayList<ImageItem> data1 = new ArrayList<ImageItem>();
    public static String[] sportsNameList = {"Athletics", "Football", "Badminton", "Cricket", "Hockey", "Basketball", "Carrom", "Chess", "LawnTennis", "TableTennis", "Snooker", "Kabaddi", "PowerLifting", "Volleyball", "Throwball", "Duathlon"};
    //public static int[] sportsImages = {R.drawable.athletics, R.drawable.football, R.drawable.badminton_one, R.drawable.cricket, R.drawable.hockey, R.drawable.basketball, R.drawable.carrom, R.drawable.chess, R.drawable.lawntennis, R.drawable.tabletennis, R.drawable.snooker, R.drawable.kabaddi, R.drawable.powerlifting, R.drawable.volleyball, R.drawable.ultimatefrisbee, R.drawable.duathlon};


    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();
        // retrieve String drawable array
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        //Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_drawer_aboutus);
        Log.d("fff", "hhh");
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, sportsNameList[i]));
        }

        return imageItems;

    }
//added


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        myGridHome = (GridView) rootView.findViewById(R.id.gridView);
        data1 = getData();
        myAdapter = new GridViewAdapter(getActivity(), R.layout.single_grid_item, data1);
        myGridHome.setAdapter(myAdapter);

        myGridHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intentHome = new Intent(view.getContext(), Parallax_GridItem.class);
                ImageItem item1 = data1.get(position);
                //intentHome.putExtra("sportImage", item1.getImage());
                intentHome.putExtra("sportName", item1.getTitle());
                intentHome.putExtra("Position", position);

             /*   Animation throw_ball = AnimationUtils.loadAnimation(view.getContext(), R.anim.hyperspace_jump);
                (view.findViewById(R.id.imageView)).startAnimation(throw_ball);
                throw_ball.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        try {
                            startActivity(intentHome);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });*/
                ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(getActivity(), R.animator.flipping);
                animator.setTarget(view);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        try {
                            startActivity(intentHome);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        });

        actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();


        return rootView;
    }


}

class ImageItem {
    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class GridViewAdapter extends ArrayAdapter<ImageItem> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ImageItem> data = new ArrayList<ImageItem>();

    public GridViewAdapter(Context context, int layoutResourceId,
                           ArrayList<ImageItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.textView);
            holder.image = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();


        }
        int[] sportsImages = {R.drawable.athletics_one, R.drawable.football_one, R.drawable.badminton_one, R.drawable.cricket_one, R.drawable.hockey_one, R.drawable.basketball_one, R.drawable.carroms_one, R.drawable.chess_one, R.drawable.tennis_one, R.drawable.table_tennis_one, R.drawable.snooker_one, R.drawable.kabaddi_one, R.drawable.power_lifting_one, R.drawable.volleyball_o, R.drawable.throw_ball, R.drawable.duathlon_one};

        ImageItem item = data.get(position);
        holder.imageTitle.setText(item.getTitle());
        Picasso.with(context).load(sportsImages[position]).into(holder.image);
        //holder.image.setImageBitmap(item.getImage());
        //Bitmap b = decodeSampledBitmapFromResource(context.getResources(), sportsImages[position], 100, 100);
        //holder.image.setImageBitmap(b);

        holder.imageTitle.setTextColor(Color.WHITE);
        holder.imageTitle.setBackgroundColor(Color.parseColor("#55000000"));
        final ViewHolder holder1 = holder;
        Palette.generateAsync(
                item.getImage(), new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch swatch = palette.getVibrantSwatch();
                        if (swatch != null) {
                            holder1.imageTitle.setBackgroundColor(swatch.getRgb());
                            holder1.imageTitle.setTextColor(swatch.getTitleTextColor());
                        }
                    }
                });
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale);
        row.startAnimation(animation);
        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}

