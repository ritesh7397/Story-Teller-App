
package com.Pbcoe.Final.StoryTellar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Pbcoe.Final.StoryTellar.R;
import com.Pbcoe.Final.StoryTellar.activities.Adult_Group;
import com.Pbcoe.Final.StoryTellar.activities.Child_Group;
import com.Pbcoe.Final.StoryTellar.activities.Mid_Age_Group;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.PagerAdapter;
import pl.droidsonroids.gif.GifImageView;

public class AgeSelectionAdapter extends PagerAdapter {

    private int[] first_gif = {

            R.drawable.jumping_girl_animation,
            R.drawable.hand_waving_animation,
            R.drawable.lady_guitarplayer
    };

    private int[] Age_Slide_Gif = {
            R.raw.black_sheep,
            R.raw.black_sheep,
            R.raw.black_sheep
    };


    private String[] first_agetext = {
            "1 - 3 Age",
            "4 - 8 Age",
            "9 - 12 Age"
    };


    private Context context;

    public AgeSelectionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return first_agetext.length;
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
        View view = inflater.inflate(R.layout.age_slide, container, false);

//        LinearLayout layout_slide = view.findViewById(R.id.Age_Linear_layout);
        CoordinatorLayout layout_slide = view.findViewById(R.id.slideLinearLayout);
        GifImageView gifImageView = view.findViewById(R.id.Age_Lottie);
        GifImageView Age_Selection_GifView = view.findViewById(R.id.Age_Selection_SlideGif);
        TextView textView = view.findViewById(R.id.Age_Selection_Number);
        Button select_btn = view.findViewById(R.id.Age_Selection_Number_Btn);

//        Age_Selection_GifView.setImageResource(R.raw.black_sheep);
        Age_Selection_GifView.setBackgroundResource(Age_Slide_Gif[position]);

        gifImageView.setImageResource(first_gif[position]);
        textView.setText(first_agetext[position]);


        select_btn.setOnClickListener(v -> {
            Intent i;

            if (position == 0) {

                i = new Intent(context, Child_Group.class);
                context.startActivity(i);
            }
            if (position == 1) {
                i = new Intent(context, Mid_Age_Group.class);
                context.startActivity(i);
            }
            if (position == 2) {
                i = new Intent(context, Adult_Group.class);
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
