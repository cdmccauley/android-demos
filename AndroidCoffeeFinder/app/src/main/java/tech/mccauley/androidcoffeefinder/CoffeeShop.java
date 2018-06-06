package tech.mccauley.androidcoffeefinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class CoffeeShop {

    private String shopName;
    private String shopAddress;
    private Drawable shopIcon;
    private Intent shopIntent;
    private Context contextPointer;

    public CoffeeShop(String name, String address, Drawable icon, Intent intent, Context context) {
        shopName = name;
        shopAddress = address;
        shopIcon = icon;
        shopIntent = intent;
        contextPointer = context;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
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
