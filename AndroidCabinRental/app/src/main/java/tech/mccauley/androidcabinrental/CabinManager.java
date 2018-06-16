package tech.mccauley.androidcabinrental;

public class CabinManager {

    protected class CabinDetails {

        private String cabinName, cabinDescription;

        public CabinDetails (String name, String description) {
            this.cabinName = name;
            this.cabinDescription = description;
        }

        public String getCabinName() {
            return cabinName;
        }

        public String getCabinDescription() {
            return cabinDescription;
        }
    }

    private static CabinManager cabinManager = new CabinManager();
    private static CabinDetails[] cabinManagerCabins;
    private static int selectedCabin;

    private CabinManager() {
        this.cabinManagerCabins = new CabinDetails[] {
                new CabinDetails("Fox Cabin", "Fox cabin is our luxurious cabin with all the amenities."),
                new CabinDetails("Hound Cabin", "Bring your friends to hound cabin where there are bunks for everyone!")
        };
        this.selectedCabin = 0;
    }

    public static CabinManager getInstance() {
        return cabinManager;
    }

    protected static CabinDetails[] getCabinManagerCabins() {
        return cabinManagerCabins;
    }

    protected static void setSelectedCabin(int cabin) {
        selectedCabin = cabin;
    }

    protected static CabinDetails getSelectedCabin() {
        return cabinManagerCabins[selectedCabin];
    }
}
