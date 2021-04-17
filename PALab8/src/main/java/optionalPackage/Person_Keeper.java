package optionalPackage;

import java.util.ArrayList;
import java.util.List;

public class Person_Keeper {
    private List<Persons> personsList;

    public Person_Keeper(){
        this.personsList = new ArrayList<>();
    }

    public List<Persons> getPersonsList() {
        return personsList;
    }

    public void addPerson(Persons person){
        personsList.add(person);
    }

    public String findById(int id){
        for (Persons person : personsList){
            if (person.getId() == id) return person.getName();
        }
        return "";
    }

    public String showAllPersons(Movies_Keeper keeper){
        StringBuilder peopleShower = new StringBuilder("We have the following people in our database:\n");
        for (Persons person : this.getPersonsList()){
            peopleShower.append(person.getName()).append(" with the job of ").append(person.getJob());
            if (person.getJob().equals("actor"))
                peopleShower.append(" that stars in the movie ").append(keeper.findById(person.getStarringIN()));
            else peopleShower.append(" that directs the movie ").append(keeper.isDirectorOf(person.getId()));
            peopleShower.append("\n");
        }
        return peopleShower.toString();
    }
}
