package tech.mccauley.androidcurrencyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // declarations
    EditText usdInputComponent;
    Spinner conversionTypeComponent;
    TextView conversionSymbolComponent, conversionResultComponent;
    String conversionType = new String();
    final double MAX_USD = 100000.00;
    final double CAD_RATE = 1.29486;
    final double EUR_RATE = 0.85754;
    final double MXN_RATE = 19.9955;
    double usdInput = 0.00;
    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        usdInputComponent = findViewById(R.id.usd_input);
        conversionTypeComponent = findViewById(R.id.conversion_type);
        conversionSymbolComponent = findViewById(R.id.conversion_symbol);
        conversionResultComponent = findViewById(R.id.conversion_result);

        // conversion_type event listener
        conversionTypeComponent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // set conversion type
                conversionType = conversionTypeComponent.getSelectedItem().toString();

                // set currency symbol
                switch (conversionType) {
                    case "CAD":
                        conversionSymbolComponent.setText(": $");
                        break;
                    case "EUR":
                        conversionSymbolComponent.setText(": €");
                        break;
                    case "MXN":
                        conversionSymbolComponent.setText(": ₱");
                        break;
                }

                ConvertCurrency();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ConvertCurrency();
            }
        });

        // usd_input event listener
        usdInputComponent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                ConvertCurrency();

                return false;
            }
        });
    }

    public void ConvertCurrency() {

        if (usdInputComponent.getText().length() != 0) {
            usdInput = Double.parseDouble(usdInputComponent.getText().toString());

            if (usdInput > MAX_USD) {

            } else {
                switch (conversionType) {
                    case "CAD":
                        conversionResultComponent.setText(moneyFormat.format(usdInput * CAD_RATE));
                        break;
                    case "EUR":
                        conversionResultComponent.setText(moneyFormat.format(usdInput * EUR_RATE));
                        break;
                    case "MXN":
                        conversionResultComponent.setText(moneyFormat.format(usdInput * MXN_RATE));
                        break;
                }
            }
        }
    }
}