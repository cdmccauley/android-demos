package tech.mccauley.androidamtraktrain;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ResultActivity.this);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH,
                sp.getInt("boardingHour", 0),
                sp.getInt("boardingMinute", 0) + sp.getInt("tripMinutes", 0));

        ComponentManager cm = ComponentManager.getInstance();

        cm.PutTextViewComponent("arrivalTv", (TextView)findViewById(R.id.arrival_tv));
        cm.SetTextViewText("arrivalTv", "The train will arrive at " + new SimpleDateFormat("HH:mm", Locale.US).format(c.getTime()));

        cm.PutTextViewComponent("redEyeTv", (TextView)findViewById(R.id.red_eye_tv));
        cm.PutImageViewComponent("redEyeIv", (ImageView)findViewById(R.id.red_eye_iv));

        if (c.get(c.HOUR_OF_DAY) >= 0 && c.get(c.HOUR_OF_DAY) <= 7) {
            cm.ShowRedEye();
        }
    }
}
