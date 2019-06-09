package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainAct extends AppCompatActivity {
    private boolean isActive;
    private ImageView fab;
    private boolean pressed = false;

     Animation zoomin = null;
     Animation zoomout = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);


        fab = findViewById(R.id.start_search);

         zoomin = AnimationUtils.loadAnimation(this, R.anim.start_anim);
         zoomout = AnimationUtils.loadAnimation(this, R.anim.finish_anim);
//        fab.setAnimation(zoomin);

//        fab.setAnimation(zoomout);

        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
//                if(!pressed) {
                    v.startAnimation(zoomin);
//                    pressed = !pressed;
//                } else {
//                    v.startAnimation(zoomout);
//                    pressed = !pressed;
//                }
                startActivity(new Intent(MainAct.this, MapHereAct.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        fab.startAnimation(zoomout);
    }
}
