package tech.mccauley.androidcabinrental;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static tech.mccauley.androidcabinrental.MainActivity.cabinManager;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    // declarations
    Context mContext;
    TextView mTextView;
    SimpleDateFormat mSimpleDateFormat;
    Calendar startDate, endDate;
    int year, month, day;
    DatePickerDialog mDatePickerDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // get main context
        mContext = getActivity();

        // get textview
        mTextView = ((Activity)mContext).findViewById(R.id.dates_text_view);

        // set simpledateformat
        mSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

        // set calendars
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();

        // set year, month, day
        year = startDate.get(Calendar.YEAR);
        month = startDate.get(Calendar.MONTH);
        day = startDate.get(Calendar.DAY_OF_MONTH);

        // set startdate
        startDate.set(year, month, day);

        // set datepickerdialog
        mDatePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);

        // set datepicker.mindate
        mDatePickerDialog.getDatePicker().setMinDate(startDate.getTimeInMillis());

        return mDatePickerDialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        // set calendars
        startDate.set(year, month, day);
        endDate.set(year, month, day + 2);

        // set textview
        mTextView.setText("Reserve " + cabinManager.getSelectedCabin().getCabinName() + " for " + mSimpleDateFormat.format(startDate.getTime()) + " through " + mSimpleDateFormat.format(endDate.getTime()));
    }
}
