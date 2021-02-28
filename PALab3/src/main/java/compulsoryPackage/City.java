package compulsoryPackage;

import java.util.ArrayList;

public class City {
    ArrayList<Locations> locationsList = new ArrayList<Locations>();
    ArrayList<Map> mappedLocations = new ArrayList<Map>();

    void addLocation(Locations givenLocation){
        locationsList.add(givenLocation);
    }

    void addRoadBetweenLocations(Locations givenLocation1,Locations givenLocation2,int givenTimeCost,boolean bothWays){
        mappedLocations.add(new Map(givenLocation1,givenLocation2,givenTimeCost));
        if(bothWays) mappedLocations.add(new Map(givenLocation2,givenLocation1,givenTimeCost));
    }
}
