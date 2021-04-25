package optionalPackage.app;

import optionalPackage.daoClasses.*;

import java.sql.Date;
import java.sql.SQLException;

public class StarterJDBC {
    public static void begin() throws SQLException, ClassNotFoundException {
        try {
            Database.rollback();
            AbstractFactory factory = new FactoryDAO();
            MovieDAO movManager = (MovieDAO) factory.movieManager();
            PeopleDAO pplManager = (PeopleDAO) factory.personManager();

            movManager.create("Godfather", Date.valueOf("2000-10-11"), 300, 8);
            pplManager.create("Gigel","Actor");
            Database.commit();

            Database.closeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Database.rollback();
        }
    }
}
