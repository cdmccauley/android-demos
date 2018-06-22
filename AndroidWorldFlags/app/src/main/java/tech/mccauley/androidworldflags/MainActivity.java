package tech.mccauley.androidworldflags;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare animation imageview
        final ImageView animationImageView = findViewById(R.id.iv_flags);

        // declare animationdrawable
        final AnimationDrawable frameAnimation = (AnimationDrawable) animationImageView.getBackground();

        // declare static imageviews
        final ImageView[] flagImageViews = new ImageView[] {
                findViewById(R.id.iv_us),
                findViewById(R.id.iv_canada),
                findViewById(R.id.iv_uk),
                findViewById(R.id.iv_france),
                findViewById(R.id.iv_germany),
                findViewById(R.id.iv_australia),
                findViewById(R.id.iv_korea),
                findViewById(R.id.iv_japan)
        };

        // declare buttons
        final Button startButton = findViewById(R.id.btn_start);
        final Button stopButton = findViewById(R.id.btn_stop);

        // startbutton click event listener
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set static imageview visibility
                for(ImageView flagImageView : flagImageViews) {
                    flagImageView.setVisibility(View.GONE);
                }

                // set animation imageview visibility
                animationImageView.setVisibility(View.VISIBLE);

                // start animation
                frameAnimation.start();

                // set button enabled
                stopButton.setEnabled(true);
                startButton.setEnabled(false);
            }
        });

        // stopbutton click event listener
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // pause animation
                frameAnimation.stop();

                // declare fadeout animation
                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator());
                fadeOut.setDuration(10000);
                fadeOut.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animationImageView.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationStart(Animation animation) { }

                    @Override
                    public void onAnimationRepeat(Animation animation) { }

                });

                // start fadeout animation
                animationImageView.startAnimation(fadeOut);

                // set button enabled
                startButton.setEnabled(true);
                stopButton.setEnabled(false);

            }
        });

        // set initial button enabled
        stopButton.setEnabled(false);

    }
}
