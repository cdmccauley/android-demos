package tech.mccauley.androiddinnerdelivery;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.util.HashMap;

public class ComponentManager {

    private static ComponentManager componentManager = new ComponentManager();
    private HashMap<String, Context> appContexts = new HashMap<>();
    private HashMap<String, Integer> componentIds = new HashMap<>();

    protected ComponentManager() {
        // prevents instantiation ??
    }

    public static ComponentManager getInstance() {
        return componentManager;
    }

    public void AddContext(String key, Context context) {
        appContexts.put(key, context);
    }

    public Context GetContext(String key) {
        return appContexts.get(key);
    }

    public void AddComponentId(String key, int id) {
        componentIds.put(key, id);
    }

    public int GetComponentId(String key) {
        return componentIds.get(key);
    }
    
    public void SetTextViewText(String contextKey, String componentKey, String text) {
        Activity subjectContext = (Activity)GetContext(contextKey);
        TextView subjectTextView = subjectContext.findViewById(GetComponentId(componentKey));
        subjectTextView.setText(text);
    }

}
