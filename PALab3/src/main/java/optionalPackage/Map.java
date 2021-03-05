package optionalPackage;

import optionalPackage.allLocations.Locations;

/**
 * @author Zamfir Adrian-Iulian
 */
public class Map {
    Locations firstLocation,secondLocation;
    int timeCost;
    boolean twoWayRoad;

    public Map(Locations givenLocation1, Locations givenLocation2, int givenTimeCost, boolean possibleTwoWay){
        this.firstLocation = givenLocation1;
        this.secondLocation = givenLocation2;
        this.timeCost = givenTimeCost;
        this.twoWayRoad = possibleTwoWay;
    }

    public String getFirstLocationName(){
        return firstLocation.getLocationName();
    }

    public String getSecondLocationName(){
        return secondLocation.getLocationName();
    }

    public int getTimeCost(){
        return this.timeCost;
    }

    public boolean getTwoWayRoad(){
        return this.twoWayRoad;
    }
}
