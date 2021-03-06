package bonusPackage.interfaces;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author Zamfir Adrian-Iulian
 */
public interface Visitable {

    default void setDefaultHours(){
        this.setOpeningHour(LocalTime.of(9,30));
        this.setClosingHour(LocalTime.of(20,0));
    }

    static Duration getVisitingDuration(LocalTime startingTime,LocalTime closingTime){
        return Duration.between(startingTime,closingTime);
    }

    LocalTime getOpeningHour();
    void setOpeningHour(LocalTime givenOpeningHour);

    LocalTime getClosingHour();
    void setClosingHour(LocalTime givenClosingHour);

}
