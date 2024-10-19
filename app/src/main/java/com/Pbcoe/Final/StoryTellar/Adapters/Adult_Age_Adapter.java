
package com.Pbcoe.Final.StoryTellar.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Pbcoe.Final.StoryTellar.R;
import com.Pbcoe.Final.StoryTellar.stories.Foolish_Donkey;
import com.Pbcoe.Final.StoryTellar.stories.GreedyLion;
import com.Pbcoe.Final.StoryTellar.stories.Honestly;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.PagerAdapter;
import pl.droidsonroids.gif.GifImageView;

public class Adult_Age_Adapter extends PagerAdapter {

    private int[] gif_slide = {
            R.raw.foolish_donky,
            R.raw.greedy_lion,
            R.raw.honesty_is_the_best_policy
    };
    //List of Images
    private int[] ist_images = {
            R.drawable.donkey_logo,
            R.drawable.lion_logo,
            R.drawable.honesty_logo

    };
    // List of Titles
    private String[] ist_title = {
            "Foolish Donkey",
            "Greedy Lion",
            "Honesty is the Best Policy"
    };
    // List Of Description
    private String[] ist_desc = {
            "A donkey who tried to reduce his load by playing tricks and at the end was taught a lesson by his owner while increasing is own suffering.",
            "A lion who became greedy for food and at the end was left with nothing.",
            "A milkman who learned his lesson for being dishonest."
    };

    //List of Background Color
    private int[] ist_back = {
            R.drawable.foolish_donky_gradient,
            R.drawable.greedy_lion_gradient,
            R.drawable.honesty_gradient
    };

    private Context context;

    public Adult_Age_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ist_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.slide, container, false);

        CoordinatorLayout layout_slide = view.findViewById(R.id.slideLinearLayout);
        ImageView img_slide = view.findViewById(R.id.slideImg);
        GifImageView gifImageView = view.findViewById(R.id.SlideGif);
        TextView txt_title = view.findViewById(R.id.TxtTitle);
        TextView txt_Desc = view.findViewById(R.id.textDesc);
        Button read_btn = view.findViewById(R.id.btnOrder);

        layout_slide.setBackgroundResource(ist_back[position]);
        gifImageView.setBackgroundResource(gif_slide[position]);
        img_slide.setImageResource(ist_images[position]);
        txt_title.setText(ist_title[position]);
        txt_Desc.setText(ist_desc[position]);


        read_btn.setOnClickListener(v -> {
            Intent i;
            if (position == 0) {
                i = new Intent(context, Foolish_Donkey.class);
                context.startActivity(i);
            }
            if (position == 1) {
                i = new Intent(context, GreedyLion.class);
                context.startActivity(i);
            }
            if (position == 2) {
                i = new Intent(context, Honestly.class);
                context.startActivity(i);
            }

        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((CoordinatorLayout) object);
    }


}
