package compulsoryPackage.controllerPack;

import compulsoryPackage.entityPack.Person;
import compulsoryPackage.repositoryPack.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PersonController {

    @Autowired
    private PersonRepository peronRepository;

    @GetMapping("persons")
    public List<Person> getPersons(){
        return this.peronRepository.findAll();
    }
}
