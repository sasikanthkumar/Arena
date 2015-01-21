package org.arenatest.bits.arena_test;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoldableAboutFragment extends android.support.v4.app.Fragment {
    private ListView mListView;
    private View mListTouchInterceptor;
    private View mDetailsLayout;
    private UnfoldableView mUnfoldableView;
    private Context context;
    //private Fragment testRoy;
    String[] titles;


    public FoldableAboutFragment(Context context) {
        // Required empty public constructor
        this.context = context;
        //testRoy = getActivity().getFragmentManager().findFragmentByTag("roy");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foldable_about, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view);


        mListTouchInterceptor = view.findViewById(R.id.touch_interceptor_view);
        mListTouchInterceptor.setClickable(false);

        mDetailsLayout = view.findViewById(R.id.details_layout);
        mDetailsLayout.setVisibility(View.INVISIBLE);

        mUnfoldableView = (UnfoldableView) view.findViewById(R.id.unfoldable_view);

        //Bitmap glance = BitmapFactory.decodeResource(context.getResources(),R.drawable.unfold_glance);
        //mUnfoldableView.setFoldShading(new GlanceFoldShading(context,glance));
        mUnfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
                mDetailsLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
                mDetailsLayout.setVisibility(View.INVISIBLE);
            }

        });


       /* titles = getActivity().getResources().getStringArray(R.array.paintings_titles);
        final TypedArray imagesTyped = getActivity().getResources().obtainTypedArray(R.array.paintings_images);
        int size = titles.length;
        int[] images = new int[size];
        for (int i = 0; i < size; i++) {
            images[i] = imagesTyped.getResourceId(i, -1);
        }
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < size; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "Country : " + titles[i]);

            hm.put("flag", Integer.toString(images[i]));
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"flag", "txt"};

        // Ids of views in listview_layout
        int[] to = {R.id.list_item_image, R.id.list_item_title};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_item, from, to);
        mListView.setAdapter(simpleAdapter);
        final int[] imagesSpare = images;
        final String[] titlesSpare = titles;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView image = (ImageView) mDetailsLayout.findViewById(R.id.details_image);
                TextView title = (TextView) mDetailsLayout.findViewById(R.id.details_title);
                TextView description = (TextView) mDetailsLayout.findViewById(R.id.details_text);
                Picasso.with(getActivity()).load(imagesSpare[position]).into(image);
                title.setText(titlesSpare[position]);
                SpannableBuilder builder = new SpannableBuilder(getActivity());
                builder
                        .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                        .append(R.string.year).append(": ")
                        .clearStyle()
                        .append(titlesSpare[position]).append("\n")
                        .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                        .append(R.string.location).append(": ")
                        .clearStyle()
                        .append(titlesSpare[position]);
                description.setText(builder.build());
                mUnfoldableView.unfold(view, mDetailsLayout);
            }
        });   */

        PaintingsAdapter pa = new PaintingsAdapter(context, mDetailsLayout, mUnfoldableView);
        mListView.setAdapter(pa);
        return view;
    }

    public UnfoldableView getmUnfoldableView() {
        return mUnfoldableView;
    }


}
