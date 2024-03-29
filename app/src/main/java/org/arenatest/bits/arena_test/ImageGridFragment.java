package org.arenatest.bits.arena_test;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by Sasikanth on 1/19/15.
 */
public class ImageGridFragment extends AbsListViewBaseFragment {

    public static final int INDEX = 1;

    //String[] imageUrls = Constants.IMAGES;
    Context con;
    DisplayImageOptions options;

    public ImageGridFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.con = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.app_logo_final)
                .showImageForEmptyUri(R.drawable.app_logo_final)
                .showImageOnFail(R.drawable.app_logo_final)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fr_image_grid, container, false);
        listView = (GridView) rootView.findViewById(R.id.grid);
        ((GridView) listView).setAdapter(new ImageAdapter());
        final String[] sportsNameList12 = {"Athletics", "Football", "Badminton", "Cricket", "Hockey", "Basketball", "Carrom", "Chess", "LawnTennis", "TableTennis", "Snooker", "Kabaddi", "PowerLifting", "Volleyball", "Throwball", "Duathlon"};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intentHome = new Intent(view.getContext(), Parallax_GridItem.class);

                intentHome.putExtra("sportName", sportsNameList12[position]);
                intentHome.putExtra("Position", position);


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
        return rootView;
    }

    public class ImageAdapter extends BaseAdapter {
        private ImageLoader imageLoader;
        private LayoutInflater inflater;
        private int[] sportsImages1 = {R.drawable.athletics_final, R.drawable.football_final, R.drawable.badminton_final, R.drawable.cricket_final, R.drawable.hockey_final, R.drawable.basketball_final, R.drawable.carroms_final, R.drawable.chess_final, R.drawable.tennis_final, R.drawable.table_tennis_final, R.drawable.billiards_final, R.drawable.kabaddi_final, R.drawable.powerlifting_final, R.drawable.volleyball_final, R.drawable.throwball_final, R.drawable.duathlon_final};
        public String[] sportsNameList1 = {"Athletics", "Football", "Badminton", "Cricket", "Hockey", "Basketball", "Carrom", "Chess", "LawnTennis", "TableTennis", "Snooker", "Kabaddi", "PowerLifting", "Volleyball", "Throwball", "Duathlon"};

        public ImageAdapter() {
            inflater = LayoutInflater.from(getActivity());
            imageLoader = ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        }

        @Override
        public int getCount() {
            return sportsImages1.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.item_grid_image, parent, false);
                holder = new ViewHolder();
                assert view != null;
                holder.imageView = (ImageView) view.findViewById(R.id.image);
                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);
                holder.text = (TextView) view.findViewById(R.id.text);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            //ImageLoader.getInstance().displayImage("drawable://" + R.drawable.ic_drawer_aboutus, holder.imageView);
            holder.text.setText(sportsNameList1[position]);
            Typeface tf = Typeface.createFromAsset(con.getAssets(), "fonts/Oswald-Regular.ttf");
            holder.text.setTypeface(tf, Typeface.ITALIC);

            imageLoader.getInstance()
                    .displayImage("drawable://" + sportsImages1[position], holder.imageView, options, new SimpleImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String imageUri, View view) {
                            holder.progressBar.setProgress(0);
                            holder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                            holder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            holder.progressBar.setVisibility(View.GONE);
                        }
                    }, new ImageLoadingProgressListener() {
                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current, int total) {
                            holder.progressBar.setProgress(Math.round(100.0f * current / total));
                        }
                    });
            Animation animation = AnimationUtils.loadAnimation(con, R.anim.scale);
            view.startAnimation(animation);
            return view;
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
        TextView text;
    }
}