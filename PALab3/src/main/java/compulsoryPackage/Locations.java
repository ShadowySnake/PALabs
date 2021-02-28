package compulsoryPackage;

import java.time.LocalTime;

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
