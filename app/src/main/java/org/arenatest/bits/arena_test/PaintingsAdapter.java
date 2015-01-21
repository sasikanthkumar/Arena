package org.arenatest.bits.arena_test;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

/**
 * Created by Sasikanth on 1/17/15.
 */
public class PaintingsAdapter extends ItemsAdapter<Painting> implements View.OnClickListener {
    private View mDetailsLayout;
    private Context context;
    private UnfoldableView mUnfoldableView;

    public PaintingsAdapter(Context context, View mDetailsLayout, UnfoldableView mUnfoldableView) {
        super(context);
        this.mUnfoldableView = mUnfoldableView;
        this.context = context;
        this.mDetailsLayout = mDetailsLayout;
        setItemsList(Arrays.asList(Painting.getAllPaintings(context.getResources())));
    }

    @Override
    protected View createView(Painting item, int pos, ViewGroup parent, LayoutInflater inflater) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        FoldableViewHolder vh = new FoldableViewHolder();
        vh.image = Views.find(view, R.id.list_item_image);
        vh.image.setOnClickListener(this);
        vh.title = Views.find(view, R.id.list_item_title);
        view.setTag(vh);

        return view;

    }

    @Override
    protected void bindView(Painting item, int pos, View convertView) {
        FoldableViewHolder vh = (FoldableViewHolder) convertView.getTag();
        vh.image.setTag(item);
        Picasso.with(convertView.getContext()).load(item.getImageId()).noFade().into(vh.image);
        //vh.image.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), item.getImageId(), 100, 100));
        vh.title.setText(item.getTitle());
        if (pos == 2) {
            vh.title.setTextColor(Color.WHITE);
        }
    }

    private static int calculateInSampleSize(
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

    private static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
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

    @Override
    public void onClick(View view) {
        View coverView = view;
        Painting painting = (Painting) view.getTag();
        ImageView image = (ImageView) mDetailsLayout.findViewById(R.id.details_image);
        TextView title = (TextView) mDetailsLayout.findViewById(R.id.details_title);
        TextView description = (TextView) mDetailsLayout.findViewById(R.id.details_text);
        Picasso.with(context).load(painting.getImageId()).into(image);
        //image.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), painting.getImageId(), 100, 100));
        title.setText(painting.getTitle());
        SpannableBuilder builder = new SpannableBuilder(context);
        builder


                .clearStyle()
                .append(painting.getLocation());
        description.setText(builder.build());
        mUnfoldableView.unfold(coverView, mDetailsLayout);
    }


    private static class FoldableViewHolder {
        ImageView image;
        TextView title;
    }
}
