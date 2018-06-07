package tech.mccauley.androidtechgadgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = getIntent().getExtras().getString("gadgetName");
        TextView titleTextView = (TextView) findViewById(R.id.title_text_view);
        titleTextView.setText(title);

    }
}
