package compulsoryPackage;

public class Map {
    Locations firstLocation,secondLocation;
    int timeCost;

    public Map(Locations givenLocation1,Locations givenLocation2,int givenTimeCost){
        this.firstLocation = givenLocation1;
        this.secondLocation = givenLocation2;
        this.timeCost = givenTimeCost;
    }
}
