package optionalPackage.controllerPackage;

import optionalPackage.entityPackage.Person;
import optionalPackage.repositoryPackage.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    private boolean personFinder(long friendsNum, String personList, Person person) {

        if (friendsNum == 0) return true;
        else if (friendsNum == 1 && personList.equals(person.getName())) return false;
        else if (friendsNum == 1 && !personList.equals(person.getName())) return true;

        String[] personNames = personList.split(", ");
        for (String personName : personNames) {
            if (personName.equals(person.getName())) return false;
        }
        return true;
    }

    private long lowestPopularity(List<Person> personList) {
        long lowestPop = 100000;
        for (Person person : personList) {
            if (person.getFriendsNumber() < lowestPop) lowestPop = person.getFriendsNumber();
        }

        return lowestPop;
    }

    private long highestPopularity(List<Person> personList) {
        long highestPop = 0;
        for (Person person : personList) {
            if (person.getFriendsNumber() > highestPop) highestPop = person.getFriendsNumber();
        }

        return highestPop;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    @GetMapping("/popularity")
    public String allPopularity() {
        StringBuilder sb = new StringBuilder("Popularity list:\n");
        this.getPersons().forEach(x -> sb.append("--- ").append(x.getName()).append(" has a total of ")
                .append(x.getFriendsNumber()).append(" which are: ").append(x.getFriendsList()).append("...\n"));
        return sb.toString();
    }

    @GetMapping("/popularity/lowest/{showMax}")
    public String lowestPopulars(@PathVariable long showMax) {

        if (showMax == 0) return "Did you just try to get the lowest 0 ranked people based on friendships ?";

        StringBuilder sb = new StringBuilder();
        List<Person> personList = this.getPersons();
        long lowPop = this.lowestPopularity(personList);
        sb.append("The lowest number of friendships is: ").append(lowPop).append("\n");

        if (showMax == 1) sb.append("One of the most unpopular people is: ");

        else sb.append("The most unpopular are: ");
        long shown = 0;

        for (Person person : personList) {
            if (shown == showMax) {
                return sb.toString();
            } else {
                if (person.getFriendsNumber() == lowPop) {
                    sb.append(person.getName()).append(" ");
                    shown++;
                }
            }
        }
        return sb.toString();
    }

    @GetMapping("/popularity/highest/{showMax}")
    public String mostPopular(@PathVariable long showMax) {
        if (showMax == 0) return "Did you just try to get the highest 0 ranked people based on friendships?";

        StringBuilder sb = new StringBuilder();
        List<Person> personList = this.getPersons();
        long highPop = this.highestPopularity(personList);
        sb.append("The highest number of friendships is: ").append(highPop).append("\n");

        if (showMax == 1) sb.append("One of the most popular people is: ");
        else sb.append("The most popular are: ");
        long shown = 0;
        for (Person person : personList) {
            if (shown == showMax) {
                return sb.toString();
            } else {
                if (person.getFriendsNumber() == highPop) {
                    sb.append(person.getName()).append(" ");
                    shown++;
                }
            }
        }

        return sb.toString();
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {

        person.setFriendsNumber(0); // default number of friends
        person.setFriendsList(null); // default list of friends
        this.personRepository.save(person);

        return "A new person with the id: " + person.getId() + " has been created!";
    }

    @PutMapping("/addFriendship/{id1}/{id2}")
    public String friendshipAdder(@PathVariable long id1, @PathVariable long id2) {
        Optional<Person> foundPerson1 = this.personRepository.findById(id1);
        Optional<Person> foundPerson2 = this.personRepository.findById(id2);

        if (!foundPerson1.isPresent()) return "The person with the id: " + id1 + " may not exist!";
        else if (!foundPerson2.isPresent()) return "The person with the id: " + id2 + "may not exist!";

        boolean notFound = personFinder(foundPerson1.get().getFriendsNumber()
                , foundPerson1.get().getFriendsList(), foundPerson2.get());

        if (!notFound) return "Attempted to add a friendship between two people that are already friends";

        Person p1 = foundPerson1.get();
        this.personRepository.delete(p1);

        Person p2 = foundPerson2.get();
        this.personRepository.delete(p2);

        if (p1.getFriendsNumber() == 0) {
            p1.setFriendsNumber(1);
            p1.setFriendsList(p2.getName());
        } else {
            p1.setFriendsNumber(p1.getFriendsNumber() + 1);
            p1.setFriendsList(p1.getFriendsList() + ", " + p2.getName());
        }

        if (p2.getFriendsNumber() == 0) {
            p2.setFriendsNumber(1);
            p2.setFriendsList(p1.getName());
        } else {
            p2.setFriendsNumber(p2.getFriendsNumber() + 1);
            p2.setFriendsList(p2.getFriendsList() + ", " + p1.getName());
        }

        this.personRepository.save(p1);
        this.personRepository.save(p2);

        return "New friendship between " + p1.getName() + " and " + p2.getName();
    }

    @PutMapping("/modify/{id}/{newName}")
    public String modifyPerson(@PathVariable long id, @PathVariable String newName) {

        Optional<Person> foundPerson = this.personRepository.findById(id);

        if (!foundPerson.isPresent())
            return "The person with the requested id has not been found!";

        Person personReplacer = foundPerson.get();
        personReplacer.setName(newName);

        this.personRepository.delete(foundPerson.get());
        this.personRepository.save(personReplacer);

        return "Successfully renamed the person!";
    }

    @DeleteMapping("/remove/{id}")
    public String deletePerson(@PathVariable long id) {
        this.personRepository.deleteById(id);
        return "The person with the id: " + id + " has been deleted!";
    }

    @DeleteMapping("/removeALL")
    public String deleteAll() {
        this.personRepository.deleteAll();
        return "All entities have been purged!";
    }
}
