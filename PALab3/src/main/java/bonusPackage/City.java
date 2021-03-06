package bonusPackage;

import bonusPackage.allLocations.Locations;

import java.util.ArrayList;


/**
 * @author Zamfir Adrian-Iulian
 */
public class City {
    ArrayList<Locations> locationsList = new ArrayList<>();
    ArrayList<Map> mappedLocations = new ArrayList<>();

    void addLocation(Locations givenLocation){
        locationsList.add(givenLocation);
    }

    /**
     *  Prints on screen all visitable locations that are not payable.
     */
    void displayFreeVisitable(){
        System.out.println("The locations that are visitable and not payable are:");
        for (Locations currentLocation : locationsList){
            if( (currentLocation.isVisitable()) && (!currentLocation.isPayable()) ){
                System.out.println(currentLocation.getLocationName());
            }
        }
    }

    ArrayList<Locations> getLocationsList(){
        return this.locationsList;
    }

    ArrayList<Map> getMappedLocations(){
        return this.mappedLocations;
    }

    /**
     * A method that places a road between two locations.
     * @param givenLocation1 is the location name of the starting point
     * @param givenLocation2 is the location name of the ending point
     * @param givenTimeCost is the time needed to get from start to end.
     * @param bothWays shows if the road can be used both ways ( from start to end  && from end to start )
     */
    void addRoadBetweenLocations(Locations givenLocation1, Locations givenLocation2, int givenTimeCost, boolean bothWays){
        mappedLocations.add(new Map(givenLocation1,givenLocation2,givenTimeCost,bothWays));
        if (bothWays) mappedLocations.add(new Map(givenLocation2,givenLocation1,givenTimeCost,bothWays));
    }

    /**
     * A method that shows the possible map of the city
     * @return returns a string containing the roads ( whole map ) of the city
     */
    @Override
    public String toString() {
       StringBuilder cityMap = new StringBuilder("\nThe map for the city is the following:\n");

       for(Map map : mappedLocations){
               cityMap.append(map.getFirstLocationName()).append(" -> ").append(map.getSecondLocationName()).append(" has the cost: ").append(map.getTimeCost()).append("\n");
       }

       return cityMap.toString();
    }
}
