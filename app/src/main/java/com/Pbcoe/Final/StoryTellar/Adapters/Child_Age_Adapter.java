
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
import com.Pbcoe.Final.StoryTellar.stories.Cat_Dog;
import com.Pbcoe.Final.StoryTellar.stories.Lion_Mouse;
import com.Pbcoe.Final.StoryTellar.stories.Scared_Lil_Mouse;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.PagerAdapter;
import pl.droidsonroids.gif.GifImageView;

public class Child_Age_Adapter extends PagerAdapter {

    private int[] gif_slide = {
            R.raw.cat_and_dog,
            R.raw.scared_little_mouse,
            R.raw.lion_and_mouse
    };

    //List of Images
    private int[] ist_images = {
            R.drawable.cat_dog_logo, //
            R.drawable.mouse_logo,
            R.drawable.lion_mouse_logo
    };
    // List of Titles
    private String[] ist_title = {
            "Cat and Dog",
            "Scared Little Mouse",
            "Lion and a Mouse"
    };
    // List Of Description
    private String[] ist_desc = {
            "A cat and dog spending time together become best friends.",
            "A big cat was chasing little mouse because of that he was scared.",
            "A lion who threatened the mouse but was saved by the same mouse during crisis",
    };


    //List of Background Color
    private int[] ist_back = {
            R.drawable.cat_dog_gradient,
            R.drawable.scared_rat_gradient,
            R.drawable.lion_mouse_gradient
    };
    private Context context;

    public Child_Age_Adapter(Context context) {
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
                i = new Intent(context, Cat_Dog.class);
                context.startActivity(i);
            }
            if (position == 1) {
                i = new Intent(context, Scared_Lil_Mouse.class);
                context.startActivity(i);
            }

            if (position == 2) {
                i = new Intent(context, Lion_Mouse.class);
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
