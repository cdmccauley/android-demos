package tech.mccauley.androidtechgadgets;

import android.content.Context;

public class TechGadgetManager {

    public TechGadgetManager(Context context) {

        // init
        mainContext = context;

        // create the tech gadgets here ??
        managerGadgets = new TechGadget[] {
                new TechGadget("Test Gadget 1"),
                new TechGadget("Test Gadget 2"),
                new TechGadget("Test Gadget 3"),
                new TechGadget("Test Gadget 4"),
                new TechGadget("Test Gadget 5"),
        };

    }

    private Context mainContext;
    private TechGadget[] managerGadgets;

    public TechGadget[] getManagerGadgets() {
        return managerGadgets;
    }

    public Context getMainContext() {
        return mainContext;
    }
}
