package tech.mccauley.androidhanadulses;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Toolbar t = findViewById(R.id.quiz_activity_tb);
        setSupportActionBar(t);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public Intent getSupportParentActivityIntent() {
        Bundle b = new Bundle();
        Intent i = new Intent(this, TabActivity.class);
        String tabName = "quizTab";
        int tabPosition = 1;

        b.putInt(tabName, tabPosition);
        i.putExtras(b);

        return i;
    }
}
