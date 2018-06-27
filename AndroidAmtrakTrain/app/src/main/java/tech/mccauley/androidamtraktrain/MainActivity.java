package tech.mccauley.androidamtraktrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // componentmanager
        ComponentManager cm = ComponentManager.getInstance();

        // boarding_et
        cm.PutEditTextComponent("boardingEt", (EditText)findViewById(R.id.boarding_et));
        cm.SetEditTextLongClickable("boardingEt", false);
        cm.OverrideBoardingEtOnClick(this);

        // trip_et
        cm.PutEditTextComponent("tripEt", (EditText)findViewById(R.id.trip_et));
        cm.OverrideTripEtOnEditorAction(this);

        // calculate_btn
        cm.PutButtonComponent("calculateBtn", (Button)findViewById(R.id.calculate_btn));
        cm.SetButtonComponentEnabled("calculateBtn", false);
        cm.OverrideCalculateBtnOnClick(this);
    }
}
