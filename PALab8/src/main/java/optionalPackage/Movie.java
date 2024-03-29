package optionalPackage;

import java.sql.Date;

public class Movie {
    private final String title;
    private final Date releaseDate;
    private final int duration;
    private final int score;
    private int id;
    private int genreId;
    private int directorId;

    public Movie(String title, Date releaseDate, int duration, int score) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
