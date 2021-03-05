package optionalPackage.allLocations;

import optionalPackage.interfaces.Classifiable;

/**
 * @author Zamfir Adrian-Iulian
 */
public class Hotel extends Locations implements Classifiable {

    public Hotel(String hotelName){
        super(hotelName);
    }

    public void setRating(int givenRating) {
        this.rating = givenRating;
    }

    public int getRating() {
        return this.rating;
    }
}
