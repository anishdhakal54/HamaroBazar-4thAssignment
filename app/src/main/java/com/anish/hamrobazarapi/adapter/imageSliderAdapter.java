package com.anish.hamrobazarapi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.anish.hamrobazarapi.R;

public class imageSliderAdapter  extends PagerAdapter {
    private Context mcontext;

    private int[] image_resource = new int[] {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};

    private int custom_position = 0;


    public imageSliderAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image_resource[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ImageView) object);
    }

}
