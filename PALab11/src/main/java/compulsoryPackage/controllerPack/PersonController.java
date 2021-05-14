package compulsoryPackage.controllerPack;

import compulsoryPackage.entityPack.Person;
import compulsoryPackage.repositoryPack.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return this.personRepository.findAll();
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {
       Person savedPerson = this.personRepository.save(person);

        return "A new person with the id: " + savedPerson.getId() + " has been created!";
    }

    @PutMapping("/modify/{id}/{newName}")
    public String modifyPerson(@PathVariable long id, @PathVariable String newName) {

            Optional<Person> foundPerson = personRepository.findById(id);

            if (!foundPerson.isPresent())
                return "The person with the requested id has not been found!";

            Person personReplacer = new Person();
            personReplacer.setId(foundPerson.get().getId());
            personReplacer.setName(newName);

            this.personRepository.delete(foundPerson.get());
            this.personRepository.save(personReplacer);

            return "Successfully renamed the person!";
    }

    @DeleteMapping("/remove/{id}")
    public String deletePerson(@PathVariable long id){
        this.personRepository.deleteById(id);
        return "The person with the id: " + id + " has been deleted!";
    }

    @DeleteMapping("/removeALL")
    public String deleteAll(){
        this.personRepository.deleteAll();
        return "All entities have been purged!";
    }
}
