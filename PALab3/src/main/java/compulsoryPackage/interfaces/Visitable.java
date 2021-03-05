package compulsoryPackage.interfaces;

import java.time.LocalTime;

/**
 * author: Zamfir Adrian-Iulian
 * An interface used for locations that can be Visited.
 */
public interface Visitable {

    LocalTime getOpeningHour();
    void setOpeningHour(LocalTime givenOpeningHour);

    LocalTime getClosingHour();
    void setClosingHour(LocalTime givenClosingHour);

}
