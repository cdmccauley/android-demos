package tech.mccauley.androidtechgadgets;

import android.os.Parcel;
import android.os.Parcelable;

public class TechGadget implements Parcelable {

    // declarations
    private String gadgetName;
    private String gadgetImage;
    private String gadgetUri;

    // constructor
    public TechGadget(String name, String image, String uri) {
        gadgetName = name;
        gadgetImage = image;
        gadgetUri = uri;
    }

    // getters
    public String getGadgetName() {
        return gadgetName;
    }

    public String getGadgetImage() {
        return gadgetImage;
    }

    public String getGadgetUri() {
        return gadgetUri;
    }

    // parcelable implementation
    protected TechGadget(Parcel in) {
        gadgetName = in.readString();
        gadgetImage = in.readString();
        gadgetUri = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gadgetName);
        dest.writeString(gadgetImage);
        dest.writeString(gadgetUri);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TechGadget> CREATOR = new Parcelable.Creator<TechGadget>() {
        @Override
        public TechGadget createFromParcel(Parcel in) {
            return new TechGadget(in);
        }

        @Override
        public TechGadget[] newArray(int size) {
            return new TechGadget[size];
        }
    };
}