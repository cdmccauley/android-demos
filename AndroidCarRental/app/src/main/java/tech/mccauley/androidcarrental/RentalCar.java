package tech.mccauley.androidcarrental;

public class RentalCar {

    private int carImage;
    private String carName;
    private double carPrice;

    public RentalCar(int image, String name, double price) {
        this.carImage = image;
        this.carName = name;
        this.carPrice = price;
    }

    public int getCarImage() {
        return carImage;
    }

    public String getCarName() {
        return carName;
    }

    public double getCarPrice() {
        return carPrice;
    }
}
