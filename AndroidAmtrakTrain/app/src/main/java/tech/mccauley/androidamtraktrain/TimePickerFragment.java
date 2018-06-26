package tech.mccauley.androidamtraktrain;

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
        Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        FieldManager fm = FieldManager.getInstance();
        Calendar c = Calendar.getInstance();

        fm.setBoardingHour(hourOfDay);
        fm.setBoardingMinute(minute);

        c.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, fm.getBoardingHour(), fm.getBoardingMinute());
        ComponentManager.getInstance().SetEditTextText("boardingEt", new SimpleDateFormat("HH:mm", Locale.US).format(c.getTime()));
    }
}
