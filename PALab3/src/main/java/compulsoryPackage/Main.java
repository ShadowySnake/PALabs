package compulsoryPackage;

/**
 * author: Zamfir Adrian-Iulian
 */
public class Main {
    public static void main(String[] args){


        /*
        Initialization of locations with actual names

        Hotel v1 = new Hotel("Emperor");
        Museum v2 = new Museum("Louvre");
        Museum v3 = new Museum("Grand Centre of Archaeology");
        Church v4 = new Church("Notre-Dame");
        Church v5 = new Church("Saint Claire");
        Restaurant v6 = new Restaurant("Grandma's sweets");
         */


        /*
        Initialization of locations without names only using v's as in the example
         */
        Hotel hotel1 = new Hotel("v1");
        Museum museum1 = new Museum("v2");
        Museum museum2 = new Museum("v3");
        Church church1 = new Church("v4");
        Church church2 = new Church("v5");
        Restaurant restaurant1 = new Restaurant("v6");

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

        System.out.println(theCity.toString());

    }
}
