package tech.mccauley.androidcabinrental;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static CabinManager cabinManager;
    private RadioGroup selectionRadioGroup;
    private RadioButton[] selectionRadioButtons;
    private TextView descriptionTextView, datesTextView;
    private Button reserveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get cabinmanager
        //cabinManager = new CabinManager();

        // get components
        selectionRadioGroup = findViewById(R.id.selection_radio_group);
        selectionRadioButtons = new RadioButton[] {
                findViewById(R.id.selection_radio_button1),
                findViewById(R.id.selection_radio_button2)
        };
        descriptionTextView = findViewById(R.id.description_text_view);
        datesTextView = findViewById(R.id.dates_text_view);
        reserveButton = findViewById(R.id.reserve_button);

        // set component attributes
        for (int i = 0; i < selectionRadioButtons.length; i++) {
            selectionRadioButtons[i].setText(cabinManager.getCabinManagerCabins()[i].getCabinName());
        }
        selectionRadioButtons[0].setChecked(true);
        descriptionTextView.setText(cabinManager.getCabinManagerCabins()[0].getCabinDescription());
        datesTextView.setText("");
        reserveButton.setText("Select Reservation Date");

        // set radiogroup checkedchange handler
        selectionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.selection_radio_button1:
                        cabinManager.setSelectedCabin(0);
                        updateUi();
                        break;
                    case R.id.selection_radio_button2:
                        cabinManager.setSelectedCabin(1);
                        updateUi();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    // update components
    private void updateUi() {
        descriptionTextView.setText(cabinManager.getSelectedCabin().getCabinDescription());
        if (!datesTextView.getText().toString().equals("")) {
            datesTextView.setText("");
        }
    }

    // mbutton onclick event handler
    public void showDatePickerDialog(View v) {

        // set fragment
        DialogFragment newFragment = new DatePickerFragment();

        // show fragment
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
