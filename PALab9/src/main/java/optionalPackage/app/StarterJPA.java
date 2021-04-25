package optionalPackage.app;

import optionalPackage.daoClasses.AbstractFactory;
import optionalPackage.daoClasses.RepoFactory;
import optionalPackage.entity.OPTMOVIE;
import optionalPackage.entity.People;
import optionalPackage.repositories.MovieRepo;
import optionalPackage.repositories.PeopleRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StarterJPA {
    static final AbstractFactory factory = new RepoFactory();
    static final MovieRepo movManager = (MovieRepo) factory.movieManager();
    static final PeopleRepo pplManager = (PeopleRepo) factory.personManager();
    static Chart moviesChart = null;

    static {
        try {
            moviesChart = new Chart("ID_CHART", movManager);
            System.out.println("In the begining the chart contains the following movies: ");
            moviesChart.printMovies();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createPerson(String personName,String job) {
        People person = new People();
        person.setName(personName);
        person.setJob(job);

        pplManager.create(person);
    }

    private static void listPersonDetail(String personName){
        System.out.println("The following has been found: ");
        List<People> peopleList = pplManager.findByName(personName);
        peopleList.forEach(x -> System.out.println(x.getId() + " " + x.getName() + " " + x.getJob()));
    }

    private static void listMovieDetails(String movieName){
        System.out.println("The following has been found: ");
        List<OPTMOVIE> moviesList = movManager.findByName(movieName);
        moviesList.forEach(x -> System.out.println(x.getId() + " " + x.getTitle() + " " + x.getReleaseDate() + " "
        + x.getDuration() + " " + x.getScore()));
    }

    private static void createMovie(String movieName, Date date, int score, int duration) {

        OPTMOVIE movie = new OPTMOVIE();
        movie.setTitle(movieName);
        movie.setReleaseDate(date);
        movie.setScore(score);
        movie.setDuration(duration);

        movManager.create(movie);
    }

    public static void start(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input your command: exit or create-person or " +
                    "create-movie or list-person-detail or list-movie-detail \n");

            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");

            switch (params[0]) {
                case "create-person":
                    createPerson(params[1],params[2]); // + the person name
                    break;
                case "create-movie":
                    createMovie(params[1], Date.valueOf(params[2]), Integer.parseInt(params[3])
                            , Integer.parseInt(params[4])); //+ the movie name, release date, duration and score
                    break;
                case "list-person-detail":
                    listPersonDetail(params[1]); //+ the person's name
                    break;
                case "list-movie-detail":
                    listMovieDetails(params[1]); // + the movie name
                    break;
            }
        }
    }
}
