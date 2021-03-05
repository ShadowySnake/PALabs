package compulsoryPackage.allLocations;

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

    public Locations(String givenName){
        this.locationName = givenName;
    }

    public String getLocationName(){
        return this.locationName;
    }
}
