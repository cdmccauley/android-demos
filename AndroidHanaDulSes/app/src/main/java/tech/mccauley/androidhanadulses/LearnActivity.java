package tech.mccauley.androidhanadulses;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LearnActivity extends AppCompatActivity {

    // declarations
    String category, answer, correctAnswer;
    TextView learnKoreanTv;
    RadioGroup englishRg;
    Button learnCheckButton;
    ArrayList<String> learnedWords;
    int currentIndex, endIndex;
    ArrayList<String> shuffledEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        // set toolbar button and title
        Toolbar t = findViewById(R.id.learn_activity_tb);
        setSupportActionBar(t);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // init
        category = getIntent().getStringExtra("category");
        learnKoreanTv = findViewById(R.id.learn_korean_tv);
        englishRg = findViewById(R.id.english_rg);
        learnCheckButton = findViewById(R.id.learn_check_button);
        learnedWords = new ArrayList<>();
        shuffledEnglish = new ArrayList<>();
        currentIndex = 0;
        endIndex = (LanguageManager.getInstance().getCategory(category).size() - 1);

        // radiogroup listener
        englishRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // enable button
                if (!learnCheckButton.isEnabled()) {
                    learnCheckButton.setEnabled(true);
                }
                // get selection
                RadioButton checkedButton = findViewById(checkedId);
                if (checkedButton != null) {
                    answer = checkedButton.getText().toString().toLowerCase();
                }

            }
        });

        // button listener
        learnCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        // begin learn activity
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
        // clear radiogroup selection
        englishRg.clearCheck();
        // disable button
        learnCheckButton.setEnabled(false);
        // check if word was learned
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
            learnKoreanTv.setText(correctAnswer);
            // get and show possible answers
            SetEnglishRg(shuffledEnglish.get(currentIndex), shuffledEnglish);
        }
    }

    // set radiogroup
    protected void SetEnglishRg(String word, ArrayList<String> words) {
        // declarations and init
        Random randomizer = new Random();
        int randomInt;
        ArrayList<Integer> randomPositions = new ArrayList<>();
        ArrayList<String> wordSet = new ArrayList<>();
        // add random possible answers to set
        while (randomPositions.size() != 3) {
            randomInt = randomizer.nextInt(words.size());
            if (!randomPositions.contains(randomInt) && !words.get(randomInt).equals(word)) {
                randomPositions.add(randomInt);
            }
        }
        // add real answer to set
        wordSet.add(word);
        // randomize set
        for (int i : randomPositions) {
            wordSet.add(words.get(i));
        }
        Collections.shuffle(wordSet);
        // set radiobuttons
        for (int i = 0; i < 4; i++) {
            RadioButton englishRb = (RadioButton)englishRg.getChildAt(i);
            englishRb.setText(wordSet.get(i));
        }
    }
}
