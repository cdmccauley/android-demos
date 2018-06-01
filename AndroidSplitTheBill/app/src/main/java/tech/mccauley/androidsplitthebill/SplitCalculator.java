package tech.mccauley.androidsplitthebill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SplitCalculator extends AppCompatActivity {

    // declarations
    final double TIP_PERCENTAGE = .18;
    EditText billTotalComponent;
    EditText partySizeComponent;
    TextView costPerPersonComponent;
    DecimalFormat moneyFormat = new DecimalFormat("$ 0.00");
    double billTotal = 0.00;
    double costPerPerson = 0.00;
    int partySize = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo_NoActionBar);
        setContentView(R.layout.activity_split_calculator);

        // get components
        billTotalComponent = findViewById(R.id.bill_total);
        partySizeComponent = findViewById(R.id.party_size);
        costPerPersonComponent = findViewById(R.id.cost_per_person);

        // bill_total event listener
        billTotalComponent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (billTotalComponent.getText().length() != 0) {
                    try {
                        billTotal = Double.parseDouble(billTotalComponent.getText().toString());
                        billTotalComponent.setText(moneyFormat.format(billTotal).toString());
                    } catch (NumberFormatException e) {
                        billTotalComponent.setText(moneyFormat.format(billTotal).toString());
                    }
                } else {
                    billTotal = 0.00;
                    billTotalComponent.setText(moneyFormat.format(billTotal).toString());
                }

                if (actionId != 0) {
                    partySizeComponent.onEditorAction(0);
                }

                processUserInput();

                return false;
            }
        });

        // party_size event listener
        partySizeComponent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (partySizeComponent.getText().length() != 0) {
                    if (partySizeComponent.getText().toString().equals("0")) {
                        partySize = 1;
                        partySizeComponent.setText(Integer.toString(partySize));
                    } else {
                        partySize = Integer.parseInt(partySizeComponent.getText().toString());
                    }
                } else {
                    partySize = 1;
                    partySizeComponent.setText(Integer.toString(partySize));
                }

                if (actionId != 0) {
                    billTotalComponent.onEditorAction(0);
                }

                processUserInput();
                
                return false;
            }
        });
    }

    public void processUserInput() {

        costPerPerson = ((billTotal * TIP_PERCENTAGE) + billTotal) / partySize;

        costPerPersonComponent.setText(moneyFormat.format(costPerPerson));

    }
}
