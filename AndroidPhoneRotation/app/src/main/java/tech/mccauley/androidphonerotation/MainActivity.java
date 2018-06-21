package tech.mccauley.androidphonerotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageView phoneImage = findViewById(R.id.imageView);
//        phoneImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.phone_rotate));

        RotateAnimation rotateImage = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateImage.setInterpolator(new LinearInterpolator());
        rotateImage.setRepeatCount(3);
        rotateImage.setDuration(1500);

        ImageView phoneImage = findViewById(R.id.imageView);
        phoneImage.startAnimation(rotateImage);
    }
}
