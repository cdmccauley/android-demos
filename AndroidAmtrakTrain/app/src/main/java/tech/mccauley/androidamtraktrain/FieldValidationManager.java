package tech.mccauley.androidamtraktrain;

public class FieldValidationManager {

    // declarations
    private static FieldValidationManager fieldValidationManager = new FieldValidationManager();
    private final int FIELD_NOT_SET = -1;
    private int boardingHour;
    private int boardingMinute;
    private int tripMinutes;
    private boolean validBoarding;

    // constructor
    private FieldValidationManager() {
        boardingHour = FIELD_NOT_SET;
        boardingMinute = FIELD_NOT_SET;
        tripMinutes = FIELD_NOT_SET;
        validBoarding = false;
    }

    // getters
    public static FieldValidationManager getInstance() {
        return fieldValidationManager;
    }

    protected int getBoardingHour() {
        return boardingHour;
    }

    protected int getBoardingMinute() {
        return boardingMinute;
    }

    protected int getTripMinutes() {
        return tripMinutes;
    }

    protected void isBoardingValid() {
        if (!validBoarding) {
            // message
        }
    }

    // setters
    protected void setBoardingHour(int hour) {
        boardingHour = hour;
        ValidateBoarding();
    }

    protected void setBoardingMinute(int minute) {
        boardingMinute = minute;
        ValidateBoarding();
    }

    protected void setTripMinutes(int minutes) {
        tripMinutes = minutes;
    }

    // validators
    private void ValidateBoarding() {
        if (boardingHour == FIELD_NOT_SET && boardingMinute == FIELD_NOT_SET) {
            validBoarding = false;
        } else {
            validBoarding = true;
        }
    }
}
