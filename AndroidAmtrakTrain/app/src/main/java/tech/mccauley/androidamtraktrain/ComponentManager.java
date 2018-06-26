package tech.mccauley.androidamtraktrain;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ComponentManager {

    private static ComponentManager componentManager;
    private HashMap<String, EditText> editTextComponents;
    private HashMap<String, Button> buttonComponents;
    private HashMap<String, TextView> textViewComponents;
    private HashMap<String, ImageView> imageViewComponents;

    private ComponentManager() {
        editTextComponents = new HashMap<>();
        buttonComponents = new HashMap<>();
        textViewComponents = new HashMap<>();
        imageViewComponents = new HashMap<>();
    }

    public static ComponentManager getInstance() {
        if (componentManager == null) {
            componentManager = new ComponentManager();
        }
        return componentManager;
    }

    /*
     *  putters
     */
    protected void PutEditTextComponent(String key, EditText component) {
        editTextComponents.put(key, component);
    }

    protected void PutButtonComponent(String key, Button component) {
        buttonComponents.put(key, component);
    }

    protected void PutTextViewComponent(String key, TextView component) {
        textViewComponents.put(key, component);
    }

    protected void PutImageViewComponent(String key, ImageView component) {
        imageViewComponents.put(key, component);
    }

    /*
     *  setters
     */
    protected void SetEditTextText(String key, String text) {
        if (editTextComponents.containsKey(key)) {
            editTextComponents.get(key).setText(text);
        }
    }

    protected void SetButtonComponentEnabled(String key, boolean value) {
        if (buttonComponents.containsKey(key)) {
            buttonComponents.get(key).setEnabled(value);
        }
    }

    protected void SetTextViewText(String key, String text) {
        if (textViewComponents.containsKey(key)) {
            textViewComponents.get(key).setText(text);
        }
    }

    /*
     *  overriders
     */
    protected void OverrideBoardingEtOnClick(final Activity activity) {
        if (editTextComponents.containsKey("boardingEt")) {
            editTextComponents.get("boardingEt").setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(activity.getFragmentManager(),"timePicker");
                }
            });
        }
    }

    protected void OverrideTripEtOnEditorAction(final Activity activity) {
        if (editTextComponents.containsKey("tripEt")) {
            editTextComponents.get("tripEt").setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (!v.getText().toString().equals("")) {
                        FieldManager.getInstance().setTripMinutes(Integer.parseInt(v.getText().toString()), activity);
                    } else {
                        FieldManager.getInstance().setTripMinutes(FieldManager.FIELD_NOT_SET, activity);
                    }
                    return false;
                }
            });
        }
    }

    protected void OverrideCalculateBtnOnClick(final Activity activity) {
        if (buttonComponents.containsKey("calculateBtn")) {
            buttonComponents.get("calculateBtn").setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FieldManager fm = FieldManager.getInstance();

                    PreferenceManager.getDefaultSharedPreferences(activity).edit()
                            .putInt("boardingHour", fm.getBoardingHour())
                            .putInt("boardingMinute", fm.getBoardingMinute())
                            .putInt("tripMinutes", fm.getTripMinutes())
                            .commit();
                    activity.startActivity(new Intent(activity, ResultActivity.class));
                }
            });
        }
    }

    /*
     *  methods
     */
    protected void MessageUser(Activity activity, String message) {
        Toast messageToast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        messageToast.show();
    }

    protected void ShowRedEye() {
        imageViewComponents.get("redEyeIv").setVisibility(View.VISIBLE);
        textViewComponents.get("redEyeTv").setVisibility(View.VISIBLE);
    }

}
