package tech.mccauley.androidmortgageinterest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    // declarations
    float monthlyPayment, loanPrincipal, interestResult;
    int loanYears;
    SharedPreferences sharedPreferences;
    TextView resultTv;
    DecimalFormat moneyFormat;
    ImageView resultIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // get sharedpreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ResultActivity.this);

        // get components
        resultTv = findViewById(R.id.result_tv);
        resultIv = findViewById(R.id.result_iv);

        // set declarations
        monthlyPayment = sharedPreferences.getFloat("monthlyPayment", 0);
        loanYears = sharedPreferences.getInt("loanYears", 10);
        loanPrincipal = sharedPreferences.getFloat("loanPrincipal", 0);

        // calculate result
        interestResult = (monthlyPayment * (loanYears * 12)) - loanPrincipal;

        // set decimalformat
        moneyFormat = new DecimalFormat("$#,##0.00");

        // set textview
        resultTv.setText("Total interest paid " + moneyFormat.format(interestResult));

        // set imageview
        switch (loanYears) {
            case 10:
                resultIv.setImageResource(R.drawable.calendar_10);
                break;
            case 20:
                resultIv.setImageResource(R.drawable.calendar_20);
                break;
            case 30:
                resultIv.setImageResource(R.drawable.calendar_30);
                break;
        }
    }
}
