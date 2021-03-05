package optionalPackage.allLocations;

import java.time.LocalTime;

/**
 * @author Zamfir Adrian-Iulian
 */
public class Locations {
    String locationName;
    double entryPrice;
    int rating;
    LocalTime openingHour;
    LocalTime closingHour;
    boolean isVisitable;
    boolean isPayable;

    public Locations(String givenName){
        this.locationName = givenName;
    }

    public String getLocationName(){
        return this.locationName;
    }

    public boolean isVisitable(){
        return isVisitable;
    }

    public boolean isPayable() {
        return isPayable;
    }
}
