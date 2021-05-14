package optionalPackage;

import optionalPackage.repositoryPackage.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OptionalMain implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(OptionalMain.class,args);
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Api has started");
    }
}
