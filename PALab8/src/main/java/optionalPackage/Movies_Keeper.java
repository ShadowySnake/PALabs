package optionalPackage;

import java.util.ArrayList;
import java.util.List;

public class Movies_Keeper {
    private List<Movie> moviesList;

    public Movies_Keeper(){
        this.moviesList = new ArrayList<>();
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void addMovie(Movie movie){
        this.moviesList.add(movie);
    }

    public String isDirectorOf(int id){
        for (Movie movie : moviesList){
            if (id == movie.getDirectorId()) return movie.getTitle();
        }
        return "";
    }

    public String findById(int id){
        for (Movie movie : moviesList){
            if (movie.getId() == id) return movie.getTitle();
        }
        return "";
    }

    public String showAllMovies(Genres_Keeper genresKeeper, Person_Keeper personKeeper){
        StringBuilder moviesShower = new StringBuilder("In the database we have the following movies:\n");
        for (Movie movie : moviesList){
            moviesShower.append(movie.getTitle()).append(" from the genre ")
                    .append(genresKeeper.findById(movie.getGenreId())).append(" ,directed by ")
                    .append(personKeeper.findById(movie.getDirectorId()))
                    .append(" released at ").append(movie.getReleaseDate())
                    .append(" that is ").append(movie.getDuration()).append(" minutes long ")
                    .append(" and has the overall score of ").append(movie.getScore()).append("\n");
        }
        return moviesShower.toString();
    }
}
