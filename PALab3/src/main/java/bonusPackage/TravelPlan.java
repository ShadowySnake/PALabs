package bonusPackage;

import bonusPackage.allLocations.Locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TravelPlan {
    City theCity;
    int numberOfDays;
    int freeTimePerDay;

    public TravelPlan(City givenCity,int givenDaysNumber){
        this.theCity = givenCity;
        this.numberOfDays = givenDaysNumber;
        this.freeTimePerDay = this.numberOfDays * 10;
    }

    public int getFreeTimePerDay() {
        return freeTimePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Method used for the buildPlanOfTravel, that helps choose what destinations ( locations ) to visit in a day.
     * @return a random boolean value
     */
    public boolean makeRandomChoice(){
        Random randomBool = new Random();
        return  randomBool.nextBoolean();
    }

    /**
     * A method that constructs a plan for visiting as many locations as possible, in an given amount of days.
     * Selecting the locations to visit, in a day, is made in a random fashion.
     * Dependent on the time allocated each day, and the cost to visit a location, this method usually visits at least half of the locations.
     * @return returns a string containing the plan of action that a tourist could choose.
     */
    String buildPlanOfTravel(){
        StringBuilder travelPlan = new StringBuilder("The plan for visiting is the following:\n");
        ArrayList<Locations> locationsList = theCity.getLocationsList();
        ArrayList<Map> mappedLocations = theCity.getMappedLocations();
        ArrayList<Integer> visitedLocations = new ArrayList<>(Arrays.asList(1,0,0,0,0,0));
        Locations startingLocation = locationsList.get(0);
        Locations currentLocation = startingLocation;
        int freeTimePerDay;
        int currentDay = 1;
        int uniqueVisitedLocations = 0;

        while (currentDay <= this.getNumberOfDays() ){
            travelPlan.append("Day ").append(currentDay).append(": ").append(currentLocation.getLocationName()).append(" -> ");
            freeTimePerDay = this.getFreeTimePerDay();

            while ( freeTimePerDay > 0){
                for (Map map : mappedLocations){
                    boolean randomBool = this.makeRandomChoice();
                    if(currentLocation.getLocationName().equals(map.getFirstLocationName())){
                        if( (randomBool) && ( (freeTimePerDay - map.getTimeCost() ) < 0) ){
                            freeTimePerDay = freeTimePerDay - map.getTimeCost();
                        }
                        else if (randomBool){
                            currentLocation = map.secondLocation;
                            if (visitedLocations.get(locationsList.indexOf(currentLocation)) == 0){
                                uniqueVisitedLocations = uniqueVisitedLocations + 1;
                                visitedLocations.set(locationsList.indexOf(currentLocation),1);
                            }
                            freeTimePerDay = freeTimePerDay - map.getTimeCost();
                            travelPlan.append(currentLocation.getLocationName()).append(" -> ");
                        }
                    }
                }
            }
            currentLocation = startingLocation;
            travelPlan.append(currentLocation.getLocationName()).append("\n");
            currentDay = currentDay + 1;
        }
        travelPlan.append("Number of unique locations visited is: ").append(uniqueVisitedLocations);
        return travelPlan.toString();
    }
}
