package tech.mccauley.androidmortgageinterest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declarations
    EditText monthlyEt;
    EditText yearsEt;
    EditText principalEt;
    Button computeBtn;
    Toast errorToast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor preferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get components
        monthlyEt = findViewById(R.id.monthly_et);
        yearsEt = findViewById(R.id.years_et);
        principalEt = findViewById(R.id.principal_et);
        computeBtn = findViewById(R.id.compute_btn);

        // set declarations
        errorToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        preferenceEditor = sharedPreferences.edit();

        // set button onclick
        computeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // validate inputs
                if (validateMonthly(monthlyEt.getText().toString()) &&
                        validateYears(yearsEt.getText().toString()) &&
                        validatePrincipal(principalEt.getText().toString())) {

                    // store values
                    preferenceEditor.putFloat("monthlyPayment", Float.parseFloat(monthlyEt.getText().toString()))
                        .putInt("loanYears", Integer.parseInt(yearsEt.getText().toString()))
                        .putFloat("loanPrincipal", Float.parseFloat(principalEt.getText().toString())).commit();

                    // start result activity
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));
                }
            }
        });
    }

    // validation methods
    public Boolean validateMonthly(String monthlyPayment) {
        if (monthlyPayment.equals("")) {
            errorToast.setText("Please enter a Monthly Payment.");
            errorToast.show();
            return false;
        } else {
            return true;
        }
    }

    public Boolean validateYears(String loanYears) {
        switch (loanYears) {
            case "10":
                return true;
            case "20":
                return true;
            case "30":
                return true;
            default:
                errorToast.setText("Loan Duration should be 10, 20, or 30.");
                errorToast.show();
                return false;
        }
    }

    public Boolean validatePrincipal(String loanPrincipal) {
        if (loanPrincipal.equals("")) {
            errorToast.setText("Please enter an Initial Principal.");
            errorToast.show();
            return false;
        } else {
            return true;
        }
    }
}
