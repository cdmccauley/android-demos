package tech.mccauley.androidamtraktrain;

import android.content.Context;

public class ComponentManager {

    private static ComponentManager componentManager;
    private final Context appContext;

    private ComponentManager(Context context) {
        appContext = context.getApplicationContext();
    }

    public static ComponentManager getInstance(Context context) {
        if (componentManager == null) {
            componentManager = new ComponentManager(context);
        }
        return componentManager;
    }

    protected void setCalculateBtnEnabled() {

    }
}
