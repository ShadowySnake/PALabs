package compulsoryPackage;

import compulsoryPackage.entityPack.Person;
import compulsoryPackage.repositoryPack.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompulsoryMain implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(CompulsoryMain.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.personRepository.save(new Person("Momon"));
        this.personRepository.save(new Person("Tony"));
        this.personRepository.save(new Person("Gilgamesh"));
    }
}
