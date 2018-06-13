package tech.mccauley.androidweddingphotography;

public class WeddingPhoto {

    // declarations
    private int photoFile;
    private String photoNum;

    // constructor
    public WeddingPhoto(String photoNum, int photoFile) {
        this.photoNum = photoNum;
        this.photoFile = photoFile;
    }

    // getters
    public String getPhotoNum() {
        return photoNum;
    }

    public int getPhotoFile() {
        return photoFile;
    }
}
