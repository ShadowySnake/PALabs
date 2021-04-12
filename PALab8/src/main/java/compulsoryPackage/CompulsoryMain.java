package compulsoryPackage;

import java.sql.Date;
import java.sql.SQLException;

public class CompulsoryMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        try {
            Database.rollback();
            GenresController genre = new GenresController();
            MovieController movie = new MovieController();
            MovieDetails details = new MovieDetails();
            genre.create("Comedy");
            genre.create("Action");
            genre.create("Horror");
            Database.commit();
            movie.create("Godfather", Date.valueOf("2000-10-11"),300,8);
            details.create(movie.findByName("Godfather"), genre.findByName("Action"));
            Database.commit();
            Database.closeConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Database.rollback();
        }
    }
}
