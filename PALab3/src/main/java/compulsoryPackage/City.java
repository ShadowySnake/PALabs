package compulsoryPackage;

import java.util.ArrayList;


/**
 * author: Zamfir Adrian-Iulian
 */
public class City {
    /**
     * Lists containing all the locations of a city, and the roads between those.
     */
    ArrayList<Locations> locationsList = new ArrayList<>();
    ArrayList<Map> mappedLocations = new ArrayList<>();

    void addLocation(Locations givenLocation){
        locationsList.add(givenLocation);
    }

    /**
     * A method that places a road between two locations.
     * @param givenLocation1 is the location name of the starting point
     * @param givenLocation2 is the location name of the ending point
     * @param givenTimeCost is the time needed to get from start to end.
     * @param bothWays shows if the road can be used both ways ( from start to end  && from end to start )
     */
    void addRoadBetweenLocations(Locations givenLocation1,Locations givenLocation2,int givenTimeCost,boolean bothWays){
        mappedLocations.add(new Map(givenLocation1,givenLocation2,givenTimeCost,bothWays));
        // if (bothWays) mappedLocations.add(new Map(givenLocation2,givenLocation1,givenTimeCost,bothWays));
    }

    /**
     * A method that shows the possible map of the city
     * @return returns a string containing the roads ( whole map ) of the city
     */
    @Override
    public String toString() {
       String cityMap = "\nThe map for the city is the following:\n";

       for(Map map : mappedLocations){
           if( map.getTwoWayRoad() ){
               cityMap = cityMap + map.getFirstLocationName() + " <-> " + map.getSecondLocationName() + " has the cost: " + map.getTimeCost() + "\n";
           }
           else{
               cityMap = cityMap + map.getFirstLocationName() + " -> " + map.getSecondLocationName() + " has the cost: " + map.getTimeCost() + "\n";
           }
       }

       return cityMap;
    }
}
