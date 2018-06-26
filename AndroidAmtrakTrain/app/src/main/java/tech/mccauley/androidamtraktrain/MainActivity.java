package tech.mccauley.androidamtraktrain;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar mainCalendar;
    EditText boardingEt, tripEt;
    Button calculateBtn;
    Toast errorToast;
    FieldValidationManager fieldValidationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainCalendar = Calendar.getInstance();

        boardingEt = findViewById(R.id.boarding_et);
        boardingEt.setHint(Integer.toString(mainCalendar.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(mainCalendar.get(Calendar.MINUTE)));

        tripEt = findViewById(R.id.trip_et);

        calculateBtn = findViewById(R.id.calculate_btn);
        fieldValidationManager = FieldValidationManager.getInstance();
        setCalculateBtnEnabled();

        errorToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        boardingEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment newFragment = new TimePickerFragment();

                newFragment.show(getFragmentManager(),"timePicker");
            }
        });

        tripEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                fieldValidationManager.setTripMinutes(Integer.parseInt(v.getText().toString()));

                setCalculateBtnEnabled();

                return false;
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setCalculateBtnEnabled() {

    }
}
