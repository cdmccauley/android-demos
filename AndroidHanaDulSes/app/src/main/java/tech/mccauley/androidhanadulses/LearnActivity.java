package tech.mccauley.androidhanadulses;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    String category, answer, correctAnswer;
    TextView learnKoreanTv;
    RadioGroup englishRg;
    Button learnCheckButton;
    ArrayList<String> learnedWords;
    ArrayList<String> unlearnedWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Toolbar t = findViewById(R.id.learn_activity_tb);
        setSupportActionBar(t);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        category = getIntent().getStringExtra("category");
        learnKoreanTv = findViewById(R.id.learn_korean_tv);
        englishRg = findViewById(R.id.english_rg);
        learnCheckButton = findViewById(R.id.learn_check_button);
        learnedWords = new ArrayList<>();
        unlearnedWords = new ArrayList<>();

        englishRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (!learnCheckButton.isEnabled()) {
                    learnCheckButton.setEnabled(true);
                }

                RadioButton checkedButton = findViewById(checkedId);
                answer = checkedButton.getText().toString().toLowerCase();

            }
        });

        learnCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast messageToast = Toast.makeText(v.getContext(), "", Toast.LENGTH_SHORT);

                if (LanguageManager.getInstance().CheckAnswer(category, answer, correctAnswer)) {
                    learnedWords.add(answer);
                    messageToast.setText("Correct!");
                } else {
                    unlearnedWords.remove(answer);
                    messageToast.setText("Wrong...");
                }
                messageToast.show();
                LearnCategory(category);
            }
        });

        LearnCategory(category);

        // get an english word
        // use english word to get korean word
        // get 3 english words that are not the english word
        // button calls method to check

//        // korean word
//        learnKoreanTv.setText(LanguageManager.getInstance().getCategory(category).values().toArray()[0].toString());
//
//        // english word
//        RadioButton answerRb = (RadioButton)englishRg.getChildAt(0);
//        answerRb.setText(LanguageManager.getInstance().getCategory(category).keySet().toArray()[0].toString());

    }

    protected void LearnCategory(String category) {

        ArrayList<String> shuffledEnglish = new ArrayList<>();

        for (Object key : LanguageManager.getInstance().getCategory(category).keySet()) {
            shuffledEnglish.add(key.toString());
            unlearnedWords.add(key.toString());
        }

        Collections.shuffle(shuffledEnglish);

        if (learnedWords.size() < 1) {

        }

//        if (!learnedWords.contains(shuffledEnglish.get())) {
//            learnCheckButton.setEnabled(false);
//            correctAnswer = (String)LanguageManager.getInstance().getCategory(category).get(shuffledEnglish.get());
//            learnKoreanTv.setText(correctAnswer);
//            SetEnglishRg(shuffledEnglish.get(), shuffledEnglish);
//        }

    }

    protected void SetEnglishRg(String word, ArrayList<String> words) {
        Random randomizer = new Random();
        int randomInt;
        ArrayList<Integer> randomPositions = new ArrayList<>();
        ArrayList<String> wordSet = new ArrayList<>();

        while (randomPositions.size() != 3) {
            randomInt = randomizer.nextInt(words.size());
            if (!randomPositions.contains(randomInt) && !words.get(randomInt).equals(word)) { // causes out of bounds
                randomPositions.add(randomInt);
            }
        }

        wordSet.add(word);
        for (int i : randomPositions) {
            wordSet.add(words.get(i));
        }
        Collections.shuffle(wordSet);

        for (int i = 0; i < 4; i++) {
            RadioButton englishRb = (RadioButton)englishRg.getChildAt(i);
            englishRb.setText(wordSet.get(i));
        }
    }
}
