package compulsoryPackage.allLocations;

import compulsoryPackage.interfaces.Payable;
import compulsoryPackage.interfaces.Visitable;

import java.time.LocalTime;

/**
 * @author Zamfir Adrian-Iulian
 */
public class Museum extends Locations implements Visitable, Payable {

    public Museum(String museumName){
        super(museumName);
    }

    public void setOpeningHour(LocalTime givenOpeningHour) {
        this.openingHour = givenOpeningHour;
    }

    public LocalTime getOpeningHour() {
        return this.openingHour;
    }

    public void setClosingHour(LocalTime givenClosingHour) {
        this.closingHour = givenClosingHour;
    }

    public LocalTime getClosingHour() {
        return this.closingHour;
    }

    public void setEntryPrice(double givenPrice) {
        this.entryPrice = givenPrice;
    }

    public double getEntryPrice() {
        return this.entryPrice;
    }
}
