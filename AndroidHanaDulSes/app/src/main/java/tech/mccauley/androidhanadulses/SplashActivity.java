package tech.mccauley.androidhanadulses;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // set task
        TimerTask splashTimerTask = new TimerTask() {
            @Override
            public void run() {
                finish();
                // start mainactivity
                //startActivity(new Intent(SplashActivity.this, MainActivity.class));
                startActivity(new Intent(SplashActivity.this, TabActivity.class));
            }
        };

        // set timer
        Timer splashTimer = new Timer();
        splashTimer.schedule(splashTimerTask, 3000);

        // get frames
        ImageView splashAnimationIv = findViewById(R.id.splash_animation_iv);
        AnimationDrawable framesXml = (AnimationDrawable)splashAnimationIv.getBackground();

        // start animation
        framesXml.start();

    }
}
