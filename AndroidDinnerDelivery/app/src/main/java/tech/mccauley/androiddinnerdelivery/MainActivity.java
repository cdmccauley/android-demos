package tech.mccauley.androiddinnerdelivery;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add component refs
        ComponentManager.getInstance().AddContext("mainContext", this);
        ComponentManager.getInstance().AddComponentId("deliveryTimeTextView", R.id.delivery_time_text_view);
    }

    // button onclick handler
    public void showTimePickerDialog(View v) {

        // get/show timepicker
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"timePicker");
    }
}
