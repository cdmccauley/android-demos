package tech.mccauley.androidcoffeefinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class CoffeeShop {

    private String shopName;
    private Drawable shopIcon;
    private Intent shopIntent;
    private Context contextPointer;

    public CoffeeShop(String name, Drawable icon, Intent intent, Context context) {
        shopName = name;
        shopIcon = icon;
        shopIntent = intent;
        contextPointer = context;
    }

    public String getShopName() {
        return shopName;
    }

    public Drawable getShopIcon() {
        return shopIcon;
    }

    public Intent getShopIntent() {
        return shopIntent;
    }

    public Context getContextPointer() {
        return contextPointer;
    }
}
