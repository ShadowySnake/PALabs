package optionalPackage;

import optionalPackage.allLocations.Locations;

import java.util.ArrayList;

public class TravelPlan {
    City theCity;
    ArrayList<Integer> visitingPreferences = new ArrayList<>();

    public TravelPlan(City givenCity){
        this.theCity = givenCity;
    }

    public void setVisitingPreferences(ArrayList<Integer> visitingPreferences) {
        this.visitingPreferences = visitingPreferences;
    }

    /**
     * A method that calculates the shortest path from one location to the other, based on the tourist preference.
     * @param startingLocation This is the starting location.
     * @param endingLocation This is the location the tourist wants to arrive to.
     * @return returns an integer containing the smallest cost between the two given locations above.
     */
    public int calculateShortestPath(Locations startingLocation, Locations endingLocation){
        System.out.println("\nThe shortest path based on preferences, starting from " + startingLocation.getLocationName() + " to " + endingLocation.getLocationName() + " has the cost:");
        Locations currentLocation = startingLocation;
        Locations nextLocation = startingLocation;
        ArrayList<Locations> locationsArrayList = theCity.getLocationsList();
        ArrayList<Map> mappedLocations = theCity.getMappedLocations();
        int totalCost = 0;
        int currentCost = 0;
        int currentPreference = 0;
        int currentLocationIndex = locationsArrayList.indexOf(currentLocation);
        int endingLocationIndex = locationsArrayList.indexOf(endingLocation);

        while ( currentLocationIndex != endingLocationIndex){
            for(Map map : mappedLocations){
                if( currentLocation.getLocationName().equals(map.getFirstLocationName()) ){
                    if( endingLocation.getLocationName().equals(map.getSecondLocationName()) ){
                        nextLocation = map.secondLocation;
                        currentCost = map.getTimeCost();
                        break;
                    }
                    if (currentPreference < visitingPreferences.get(locationsArrayList.indexOf(map.secondLocation))) {
                        currentPreference = visitingPreferences.get(locationsArrayList.indexOf(map.secondLocation));
                        nextLocation = map.secondLocation;
                        currentCost = map.getTimeCost();
                    }
                }
            }

            totalCost = totalCost + currentCost;
            currentLocation = nextLocation;
            currentLocationIndex = locationsArrayList.indexOf(currentLocation);
            currentPreference = 0;
        }

        return totalCost;
    }
}
