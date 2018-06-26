package tech.mccauley.androidamtraktrain;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    Calendar c;
    TimePickerDialog timePicker;
    FieldValidationManager fieldValidationManager;
    ComponentManager componentManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        fieldValidationManager = FieldValidationManager.getInstance();

        c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        timePicker = new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));

        return timePicker;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        fieldValidationManager.setBoardingHour(hourOfDay);
        fieldValidationManager.setBoardingMinute(minute);
    }
}
