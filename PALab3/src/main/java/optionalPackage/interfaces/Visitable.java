package optionalPackage.interfaces;

import java.time.LocalTime;

/**
 * @author Zamfir Adrian-Iulian
 */
public interface Visitable {

    default void setDefaultHours(){
        this.setOpeningHour(LocalTime.of(9,30));
        this.setClosingHour(LocalTime.of(20,0));
    }

    LocalTime getOpeningHour();
    void setOpeningHour(LocalTime givenOpeningHour);

    LocalTime getClosingHour();
    void setClosingHour(LocalTime givenClosingHour);

}
