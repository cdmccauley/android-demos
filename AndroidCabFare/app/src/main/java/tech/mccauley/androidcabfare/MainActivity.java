package tech.mccauley.androidcabfare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare/get components
        final EditText mileEditTxt = findViewById(R.id.mileEdtTxt);
        final TextView milePriceTxtVw = findViewById(R.id.milePriceTxtVw);
        final TextView totalPriceTxtVw = findViewById(R.id.totalPriceTxtVw);

        // process user input when soft keyboard enter is pressed
        mileEditTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                // method declarations
                double userMileage, mileTotal, total;
                final double BASE_RATE = 3.00;
                final double MILE_RATE = 3.25;

                // get user specification
                if (mileEditTxt.getText().length() == 0) { // input was not entered
                    userMileage = 0.00;
                } else { // input was entered
                    userMileage = Double.parseDouble(mileEditTxt.getText().toString());
                }

                // process user specification
                mileTotal = MILE_RATE * userMileage;
                total = BASE_RATE + MILE_RATE * userMileage;
                DecimalFormat moneyFormat = new DecimalFormat("$ 0.00");

                // display totals
                milePriceTxtVw.setText(moneyFormat.format(mileTotal).toString());
                totalPriceTxtVw.setText(moneyFormat.format(total).toString());

                // closes soft keyboard
                return false;
            }
        });

    }
}
