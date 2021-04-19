package compulsoryPackage.app;

import compulsoryPackage.controller.MovieController;
import compulsoryPackage.controller.PersonController;
import compulsoryPackage.entity.Movie;
import compulsoryPackage.entity.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class App {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesPU");
    static final PersonController personController = new PersonController(emf);
    static final MovieController movieController = new MovieController(emf);

    public static void main(String[] args) {
        new App().run();
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input your command:\n");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");

            switch (params[0]) {
                case "create-person":
                    createPerson(params[1]); // + the person name
                    break;
                case "create-movie":
                    createMovie(params[1], params[2]); //+ the movie name and the director name
                    break;
                case "list-movies-by-director":
                    listMoviesByDirector(params[1]); //+ the director name
                    break;
                case "list-movie-detail":
                    listMovieDetails(params[1]); // + the movie name
                    break;
            }
        }

    }

    private void createPerson(String personName) {
        Person person = new Person();
        person.setName(personName);

        personController.create(person);
    }

    private void createMovie(String movieName, String directorName) {
        Person director = personController.findByName(directorName);

        if (director == null)
            return;

        Movie movie = new Movie();
        movie.setName(movieName);
        movie.setDirectorId(director.getId());

        movieController.create(movie);
    }

    private void listMovieDetails(String movieName) {
        Movie foundMovie = movieController.findByName(movieName);
        if (foundMovie == null) return;
        Person director = personController.findById(foundMovie.getDirectorId());
        System.out.println("The movie has the id " + foundMovie.getId() + " and is directed by " + director.getName());
    }

    private void listMoviesByDirector(String directorName) {
        Person director = personController.findByName(directorName);

        if (director == null)
            return;

        List<Movie> movies = movieController.findByDirectorId(director.getId());

        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }
}
