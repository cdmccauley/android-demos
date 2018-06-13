package tech.mccauley.androidweddingphotography;

public class PhotoManager {

    // declarations
    private WeddingPhoto[] managerPhotos;

    // constructor
    public PhotoManager() {
        managerPhotos = new WeddingPhoto[] {
                new WeddingPhoto("1", R.drawable.photo1),
                new WeddingPhoto("2", R.drawable.photo2),
                new WeddingPhoto("3", R.drawable.photo3),
                new WeddingPhoto("4", R.drawable.photo4),
                new WeddingPhoto("5", R.drawable.photo5),
                new WeddingPhoto("6", R.drawable.photo6),
                new WeddingPhoto("7", R.drawable.photo7),
                new WeddingPhoto("8", R.drawable.photo8),
                new WeddingPhoto("9", R.drawable.photo9),
                new WeddingPhoto("10", R.drawable.photo10)
        };
    }

    // getters
    public WeddingPhoto[] getManagerPhotos() {
        return managerPhotos;
    }
}
