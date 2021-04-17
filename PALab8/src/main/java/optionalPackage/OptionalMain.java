package optionalPackage;

import java.sql.Date;
import java.sql.SQLException;

public class OptionalMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        try {
            Database.rollback();

            GenresController genre = new GenresController();
            PersonController person = new PersonController();
            MovieController movie = new MovieController();
            MovieDetails details = new MovieDetails();

            Movies_Keeper fullMovies = new Movies_Keeper();
            Person_Keeper allPersons = new Person_Keeper();
            Genres_Keeper allGenres = new Genres_Keeper();


            genre.create(new Genres("Comedy"),allGenres);
            genre.create(new Genres("Action"),allGenres);
            genre.create(new Genres("Horror"),allGenres);
            Database.commit();

            movie.create(new Movie("Godfather", Date.valueOf("2000-10-11"),300,8),fullMovies);
            person.create(new Actor(133,"Sully", movie.findByName("Godfather")),allPersons);
            person.create(new Director(1,"Connor"),allPersons);
            details.create(movie.findByName("Godfather"), genre.findByName("Action"), person.findByName("Connor"),fullMovies);
            Database.commit();

            System.out.println(fullMovies.showAllMovies(allGenres,allPersons));
            System.out.println(allPersons.showAllPersons(fullMovies));

            Database.closeConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Database.rollback();
        }
    }
}
