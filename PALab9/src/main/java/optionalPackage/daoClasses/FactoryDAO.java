package optionalPackage.daoClasses;

public class FactoryDAO implements AbstractFactory {
    @Override
    public MovieDAO movieManager() {
        return new MovieDAO();
    }

    @Override
    public PeopleDAO personManager() {
        return new PeopleDAO();
    }
}
