package compulsoryPackage;

import java.time.LocalTime;

public class Church extends Locations implements Visitable{

    public Church(String churchName){
        super(churchName);
    }

    public LocalTime getOpeningHour() {
        return this.openingHour;
    }

    public void setOpeningHour(LocalTime givenOpeningHour) {
        this.openingHour = givenOpeningHour;
    }

    public LocalTime getClosingHour() {
        return this.closingHour;
    }

    public void setClosingHour(LocalTime givenClosingHour) {
        this.closingHour = givenClosingHour;
    }
}
