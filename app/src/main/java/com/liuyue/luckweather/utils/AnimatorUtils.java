package com.liuyue.luckweather.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;


public class AnimatorUtils {

    public static void setScalse(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator_x = ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.2f, 1f, 0.5f, 0.7f,1f);
        ObjectAnimator animator_y = ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.2f, 1f, 0.5f, 0.7f,1f);
        set.play(animator_x).with(animator_y);
        set.setDuration(500);
        set.start();
    }

    public static void roundLoad(View myView){

        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());
        AnimatorSet animatorSet=new AnimatorSet();
        Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        anim.setDuration(1000);
        anim.setInterpolator(new AccelerateInterpolator());

        Animator anim1 =ObjectAnimator.ofFloat(myView, "translationZ", 0f,50f);
        anim1.setDuration(1500);
        anim1.setInterpolator(new AccelerateInterpolator());

        animatorSet.play(anim).with(anim1);

        myView.setVisibility(View.VISIBLE);
        animatorSet.start();
    }

}
