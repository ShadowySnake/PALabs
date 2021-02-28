package compulsoryPackage;

import java.time.LocalTime;

public interface Visitable {

    LocalTime getOpeningHour();
    void setOpeningHour(LocalTime givenOpeningHour);

    LocalTime getClosingHour();
    void setClosingHour(LocalTime givenClosingHour);

}
