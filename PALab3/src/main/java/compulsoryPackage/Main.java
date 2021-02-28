package compulsoryPackage;

public class Main {
    public static void main(String[] args){

        Hotel v1 = new Hotel("Emperor");
        Museum v2 = new Museum("Louvre");
        Museum v3 = new Museum("Grand Centre of Archaeology");
        Church v4 = new Church("Notre-Dame");
        Church v5 = new Church("Saint Claire");
        Restaurant v6 = new Restaurant("Grandma's sweets");

        City theCity = new City();
        theCity.addLocation(v1);
        theCity.addLocation(v2);
        theCity.addLocation(v3);
        theCity.addLocation(v4);
        theCity.addLocation(v5);
        theCity.addLocation(v6);

        theCity.addRoadBetweenLocations(v1,v2,10,false);
        theCity.addRoadBetweenLocations(v1,v3,50,false);
        theCity.addRoadBetweenLocations(v2,v3,20,true);
        theCity.addRoadBetweenLocations(v2,v4,20,false);
        theCity.addRoadBetweenLocations(v1,v5,10,false);
        theCity.addRoadBetweenLocations(v3,v4,20,false);
        theCity.addRoadBetweenLocations(v4,v5,30,true);
        theCity.addRoadBetweenLocations(v4,v6,10,false);
        theCity.addRoadBetweenLocations(v5,v6,20,false);


    }
}
