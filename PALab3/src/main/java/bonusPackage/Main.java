package bonusPackage;

import bonusPackage.allLocations.Church;
import bonusPackage.allLocations.Hotel;
import bonusPackage.allLocations.Museum;
import bonusPackage.allLocations.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Zamfir Adrian-Iulian
 */
public class Main {
    public static void main(String[] args){


        /*
        Initialization of locations
         */
        Hotel hotel1 = new Hotel("Emperor (v1)");
        Museum museum1 = new Museum("Louvre (v2)");
        Museum museum2 = new Museum("Grand Centre of Archaeology (v3)");
        Church church1 = new Church("Notre-Dame (v4)");
        Church church2 = new Church("Saint Claire (v5)");
        Restaurant restaurant1 = new Restaurant("Grandma's sweets (v6)");

        /*
        Initialization of a city with all of the locations
         */
        City theCity = new City();
        theCity.addLocation(hotel1);
        theCity.addLocation(museum1);
        theCity.addLocation(museum2);
        theCity.addLocation(church1);
        theCity.addLocation(church2);
        theCity.addLocation(restaurant1);

        /*
        Adding the roads by both locations that it unifies,timeCost and the possibility of the road being twoWay.
         */
        theCity.addRoadBetweenLocations(hotel1,museum1,10,false);
        theCity.addRoadBetweenLocations(hotel1,museum2,50,false);
        theCity.addRoadBetweenLocations(museum1,museum2,20,true);
        theCity.addRoadBetweenLocations(museum1,church1,20,false);
        theCity.addRoadBetweenLocations(hotel1,church2,10,false);
        theCity.addRoadBetweenLocations(museum2,church1,20,false);
        theCity.addRoadBetweenLocations(church1,church2,30,true);
        theCity.addRoadBetweenLocations(church1,restaurant1,10,false);
        theCity.addRoadBetweenLocations(church2,restaurant1,20,false);

        TravelPlan planOfTravel = new TravelPlan(theCity,5);
        System.out.println(planOfTravel.buildPlanOfTravel());

    }
}
