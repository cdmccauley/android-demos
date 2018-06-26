package tech.mccauley.androidamtraktrain;

import android.app.Activity;

public class FieldManager {

    private static FieldManager fieldManager;
    public static final int FIELD_NOT_SET = -1;
    private int boardingHour;
    private int boardingMinute;
    private int tripMinutes;

    private FieldManager() {
        boardingHour = FIELD_NOT_SET;
        boardingMinute = FIELD_NOT_SET;
        tripMinutes = FIELD_NOT_SET;
    }

    public static FieldManager getInstance() {
        if (fieldManager == null) {
            fieldManager = new FieldManager();
        }
        return fieldManager;
    }

    /*
     *  setters
     */
    protected void setBoardingHour(int hour) {
        boardingHour = hour;
        ValidateFields();
    }

    protected void setBoardingMinute(int minute) {
        boardingMinute = minute;
        ValidateFields();
    }

    protected void setTripMinutes(int minutes, final Activity activity) {
        if (minutes < 0 || minutes > 1500) {
            tripMinutes = FIELD_NOT_SET;
            ComponentManager.getInstance().MessageUser(activity, "Trip Duration must be 0-1500");
        } else {
            tripMinutes = minutes;
        }
        ValidateFields();
    }

    /*
     *  getters
     */
    protected int getBoardingHour() {
        if (boardingHour != FIELD_NOT_SET) {
            return boardingHour;
        } else {
            return FIELD_NOT_SET;
        }
    }

    protected int getBoardingMinute() {
        if (boardingMinute != FIELD_NOT_SET) {
            return boardingMinute;
        } else {
            return FIELD_NOT_SET;
        }
    }

    protected int getTripMinutes() {
        if (tripMinutes != FIELD_NOT_SET) {
            return tripMinutes;
        } else {
            return FIELD_NOT_SET;
        }
    }

    /*
     *  methods
     */
    private void ValidateFields() {
        ComponentManager cm = ComponentManager.getInstance();
        if (boardingHour != FIELD_NOT_SET && boardingMinute != FIELD_NOT_SET && tripMinutes != FIELD_NOT_SET) {
            cm.SetButtonComponentEnabled("calculateBtn", true);
        } else {
            cm.SetButtonComponentEnabled("calculateBtn", false);
        }
    }
}
