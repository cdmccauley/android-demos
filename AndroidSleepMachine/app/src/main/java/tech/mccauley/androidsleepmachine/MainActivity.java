package tech.mccauley.androidsleepmachine;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // declarations
    Button audioButton1, audioButton2;
    MediaPlayer audio1, audio2;
    boolean audioPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        audioButton1 = findViewById(R.id.audio_button_1);
        audioButton2 = findViewById(R.id.audio_button_2);
        audio1 = new MediaPlayer();
        audio1 = MediaPlayer.create(this, R.raw.audio1);
        audio2 = new MediaPlayer();
        audio2 = MediaPlayer.create(this, R.raw.audio2);
        audioPlaying = false;

        // set audio_button_1 listener
        audioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!audioPlaying) {
                    audio1.start();
                    audioPlaying = true;
                    audioButton1.setText("Pause");
                    audioButton2.setEnabled(false);
                } else {
                    audio1.pause();
                    audioPlaying = false;
                    audioButton1.setText("Play");
                    audioButton2.setEnabled(true);
                }
            }
        });

        // set audio_button_2 listener
        audioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!audioPlaying) {
                    audio2.start();
                    audioPlaying = true;
                    audioButton2.setText("Pause");
                    audioButton1.setEnabled(false);
                } else {
                    audio2.pause();
                    audioPlaying = false;
                    audioButton2.setText("Play");
                    audioButton1.setEnabled(true);
                }
            }
        });

    }
}
