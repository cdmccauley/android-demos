package tech.mccauley.androidhanadulses;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    String category, answer, correctAnswer;
    TextView quizKoreanTv;
    EditText englishEt;
    Button quizCheckButton;
    ArrayList<String> shuffledEnglish;
    ArrayList<String> learnedWords;
    int currentIndex, endIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // set toolbar button and title
        Toolbar t = findViewById(R.id.quiz_activity_tb);
        setSupportActionBar(t);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // init
        category = getIntent().getStringExtra("category");
        quizKoreanTv = findViewById(R.id.quiz_korean_tv);
        englishEt = findViewById(R.id.english_et);
        quizCheckButton = findViewById(R.id.quiz_check_button);
        shuffledEnglish = new ArrayList<>();
        learnedWords = new ArrayList<>();
        currentIndex = 0;
        endIndex = (LanguageManager.getInstance().getCategory(category).size() - 1);

        // button listener
        quizCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get user answer
                answer = englishEt.getText().toString().toLowerCase();

                // set toast
                Toast messageToast = Toast.makeText(v.getContext(), "", Toast.LENGTH_SHORT);
                messageToast.setGravity(Gravity.BOTTOM, 0, 300);
                View toastView = messageToast.getView();
                Drawable toastBackground = toastView.getBackground();

                // check user selection then message
                if (LanguageManager.getInstance().CheckAnswer(category, answer, correctAnswer)) {
                    if (!learnedWords.contains(answer)) {
                        learnedWords.add(answer);
                    }
                    messageToast.setText("Correct!");
                    DrawableCompat.setTint(toastBackground, getResources().getColor(R.color.greenAlpha));
                } else {
                    messageToast.setText("Wrong...");
                    DrawableCompat.setTint(toastBackground, getResources().getColor(R.color.redAlpha));
                }

                // set position index
                if (currentIndex == endIndex) {
                    currentIndex = 0;
                } else {
                    currentIndex = currentIndex + 1;
                }

                // check for completion or get next word
                if (learnedWords.size() == shuffledEnglish.size()) {
                    messageToast.setText("Category complete!");
                    messageToast.show();
                    finish();
                } else {
                    messageToast.show();
                    GetNextWord();
                }

            }
        });

        // begin quiz activity
        GetCategoryWords();
        GetNextWord();
    }

    // get and re-order category words
    protected void GetCategoryWords() {
        for (Object key : LanguageManager.getInstance().getCategory(category).keySet()) {
            shuffledEnglish.add(key.toString());
        }
        Collections.shuffle(shuffledEnglish);
    }

    // get next word in category
    protected void GetNextWord() {
        // clear edittext text
        englishEt.setText("");
        // check if word correct
        if (learnedWords.contains(shuffledEnglish.get(currentIndex))) {
            if (currentIndex == endIndex) {
                currentIndex = 0;
            } else {
                currentIndex = currentIndex + 1;
            }
            GetNextWord();
        } else {
            // get correct answer and show korean
            correctAnswer = (String)LanguageManager.getInstance().getCategory(category).get(shuffledEnglish.get(currentIndex));
            quizKoreanTv.setText(correctAnswer);
        }
    }

    // override sets tab activity current tab when parent activity is called
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
