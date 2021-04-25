package optionalPackage.daoClasses;

import optionalPackage.repositories.MovieRepo;
import optionalPackage.repositories.PeopleRepo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepoFactory implements AbstractFactory{
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesPU");
    @Override
    public MovieRepo movieManager() {
        return new MovieRepo(emf);
    }

    @Override
    public PeopleRepo personManager() {
        return new PeopleRepo(emf);
    }
}
