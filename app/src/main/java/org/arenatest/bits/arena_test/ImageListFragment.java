package org.arenatest.bits.arena_test;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sasikanth on 1/19/15.
 */
public class ImageListFragment extends AbsListViewBaseFragment {

    public static final int INDEX = 0;

    //String[] imageUrls = Constants.IMAGES;

    DisplayImageOptions options2;
    Boolean flag;
    Context con1;

    public ImageListFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.con1 = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = false;
        setHasOptionsMenu(true);
        options2 = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.app_logo_final)
                .showImageForEmptyUri(R.drawable.app_logo_final)
                .showImageOnFail(R.drawable.app_logo_final)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fr_image_list, container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);
        ((ListView) listView).setAdapter(new ImageAdapterList());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //startImagePagerActivity(position);
                //Log.d("aa", "aaa");
                if (!flag) {
                    flag = true;
                    Dialog dialog = new Dialog(con1);
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            flag = false;
                        }
                    });
                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            flag = false;
                        }
                    });

                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog);
                    TextView phoneText = (TextView) dialog.findViewById(R.id.phoneText);
                    TextView emailText = (TextView) dialog.findViewById(R.id.emailText);
                    dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;


                    switch (position) {

                        case 0:
                            phoneText.setText("+91-9032775678");
                            emailText.setText("harsha@bits-arena.com");
                            dialog.show();
                            break;
                        case 1:
                            phoneText.setText("+91-9912702673");
                            emailText.setText("shrivani@bits-arena.com");
                            dialog.show();
                            break;
                        case 2:
                            phoneText.setText("+91-8464992947");
                            emailText.setText("shashank@bits-arena.com");
                            emailText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                            dialog.show();
                            break;
                        case 3:
                            phoneText.setText("+91-9542553851");
                            emailText.setText("mrudul@bits-arena.com");
                            dialog.show();
                            break;
                        case 4:
                            phoneText.setText("+91-9618102392");
                            emailText.setText("snehith@bits-arena.com");
                            dialog.show();
                            break;


                    }


                }
            }
        });
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AnimateFirstDisplayListener.displayedImages.clear();
    }


    private static class ViewHolder {
        TextView text;
        TextView text1;
        ImageView image;
    }

    private class ImageAdapterList extends BaseAdapter {

        private LayoutInflater inflater;
        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
        private int[] imageUrls = {R.drawable.harsha_final, R.drawable.srivani_final, R.drawable.battar_final, R.drawable.mrudul_final, R.drawable.budime_final};
        private String[] text = {"Harsha Aechuri", "Shrivani Pandiya", "Shashank Battar", "Mrudul Nekkanti", "Snehith Budime"};
        private String[] text1 = {"Sports Secretary,Students Union", "Sports Secretary, Students Union ", "Registration and Hospitatilty", "Sponsorship and Marketing", "Pubilcity and Public Relations"};

        public ImageAdapterList() {
            inflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getCount() {
            return imageUrls.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            final ViewHolder holder;
            if (convertView == null) {
                view = inflater.inflate(R.layout.item_list_image, parent, false);
                holder = new ViewHolder();
                holder.text1 = (TextView) view.findViewById(R.id.text1);
                holder.text = (TextView) view.findViewById(R.id.text);
                holder.image = (ImageView) view.findViewById(R.id.image);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.text.setText(text[position]);
            holder.text1.setText(text1[position]);
            ImageLoader.getInstance().displayImage("drawable://" + imageUrls[position], holder.image, options2, animateFirstListener);

            return view;
        }
    }

    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
}