package tech.mccauley.androidtechgadgets;

import android.content.Context;

public class TechGadgetManager {

    // declarations
    private Context mainContext;
    private TechGadget[] managerGadgets;

    // constructor
    public TechGadgetManager(Context context) {

        // initialize
        mainContext = context;
        managerGadgets = new TechGadget[] {
                new TechGadget("ASUS 27\" 4K UHD 144Hz Monitor", "monitor", "https://www.newegg.com/Product/Product.aspx?Item=N82E16824236885"),
                new TechGadget("ASUS GTX 1080 TI 11GB Graphics Card", "graphicscard", "https://www.newegg.com/Product/Product.aspx?Item=N82E16814126202"),
                new TechGadget("Corsair 760W ATX12V/EPS12V Supply", "powersupply", "https://www.newegg.com/Product/Product.aspx?Item=9SIA85V3GC9032"),
                new TechGadget("EKWB CPU/GPU Liquid Cooling Kit", "coolingkit", "https://www.newegg.com/Product/Product.aspx?Item=9SIAC8W5SB2259"),
                new TechGadget("Samsung 970 PRO 1TB M.2 2280 Internal SSD", "ssd", "https://www.newegg.com/Product/Product.aspx?Item=9SIA12K77Z5902"),
        };
    }

    // getters
    public TechGadget[] getManagerGadgets() {
        return managerGadgets;
    }

    public Context getMainContext() {
        return mainContext;
    }
}
