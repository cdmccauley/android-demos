package tech.mccauley.androidyourcontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // detail button 1
        final Button button1 = findViewById(R.id.DetailBtn1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailAct1.class));
            }
        });

        // detail button 2
        final Button button2 = findViewById(R.id.DetailBtn2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailAct2.class));
            }
        });
    }
}
