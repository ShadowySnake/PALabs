package optionalPackage.app;

import optionalPackage.entity.OPTMOVIE;
import optionalPackage.repositories.MovieRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Chart {
    String chartName;
    Date creationDate;
    List<OPTMOVIE> movies;

    public Chart(String name, MovieRepo manager) throws SQLException, ClassNotFoundException {
        this.chartName = name;
        movies = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        creationDate = Date.valueOf(dtf.format(now));
        movies = manager.getAllMovies();
    }

    public void addMovie(OPTMOVIE movie) {
        movies.add(movie);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String name) {
        this.chartName = name;
    }

    public List<OPTMOVIE> getMovies() {
        return movies;
    }

    public void setMovies(List<OPTMOVIE> movies) {
        this.movies = movies;
    }

    public void removeMovie(int index) {
        movies.remove(index);
    }

    public void printMovies() {
        movies.forEach(x -> System.out.println(x.getTitle()));
    }
}
