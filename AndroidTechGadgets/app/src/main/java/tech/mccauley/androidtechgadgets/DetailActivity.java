package tech.mccauley.androidtechgadgets;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    // declarations
    private TechGadget techGadget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // get techgadget
        techGadget = getIntent().getExtras().getParcelable("techGadget");

        // set title
        TextView titleTextView = findViewById(R.id.title_text_view);
        titleTextView.setText(techGadget.getGadgetName());

        // set image
        ImageView imageImageView = findViewById(R.id.image_image_view);
        imageImageView.setImageResource(getResources().getIdentifier(techGadget.getGadgetImage(), "drawable", getPackageName()));

        // set button
        Button websiteButton = findViewById(R.id.website_button);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(techGadget.getGadgetUri()));
                startActivity(webIntent);
            }
        });

    }
}
