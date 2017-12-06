package com.omniroid.tapan.portfolioapp.view.splash;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.omniroid.tapan.portfolioapp.view.activity.HomeActivity;
import com.omniroid.tapan.portfolioapp.R;
import com.sdsmdg.harjot.rotatingtext.RotatingTextWrapper;
import com.sdsmdg.harjot.rotatingtext.models.Rotatable;

public class SpalshScreenActivity extends AppCompatActivity {


    private Typeface typeface;
    private RotatingTextWrapper rotatingTextWrapper;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.status));

        //abrilfatface
        typeface = Typeface.createFromAsset(getAssets(), "fonts/abrilfatface.ttf");

        rotatingTextWrapper = (RotatingTextWrapper) findViewById(R.id.custom_switcher);
        rotatingTextWrapper.setSize(18);

        Rotatable rotatable = new Rotatable(Color.parseColor("#FFFFFF"), 1000, "Unique", "Artist", "Ambitious");
        rotatable.setSize(55);
        rotatable.setTypeface(typeface);
        rotatable.setAnimationDuration(500);

        rotatingTextWrapper.setContent("?", rotatable);
        sleep(2700);
    }

    private void sleep(long time) {
       Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                //what ever you do here will be done after 3 seconds delay.

                Intent intent = new Intent(SpalshScreenActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        };
        handler.postDelayed(r, time);
    }
}
