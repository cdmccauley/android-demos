package tech.mccauley.androiddinnerdelivery;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // get current time values
        Calendar c = Calendar.getInstance();

        //TimePickerDialog deliveryTime = new TimePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK,this, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), DateFormat.is24HourFormat(getActivity()));
        RangeTimePickerDialog deliveryTime = new RangeTimePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK,this, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), DateFormat.is24HourFormat(getActivity()));
        deliveryTime.setMax(23, 00);
        if (c.get(Calendar.HOUR_OF_DAY) > 17) {
            deliveryTime.setMin(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
        } else {
            deliveryTime.setMin(17, 00);
        }
        deliveryTime.setTitle("Delivery Hours: 5:00 PM - 11:00 PM");

        return deliveryTime;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, hourOfDay, minute);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);

        String deliveryMessage = "Your delivery will be scheduled to arrive at " + sdf.format(c.getTime());

        ComponentManager.getInstance().SetTextViewText("mainContext", "deliveryTimeTextView", deliveryMessage);

    }
}
