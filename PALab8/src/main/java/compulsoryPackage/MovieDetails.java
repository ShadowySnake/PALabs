package compulsoryPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDetails {

    public void create(Integer movieID, Integer genreID) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            String sql = "insert into movie_genres values(?,?,?,?)";
            GenresController genre = new GenresController();
            MovieController movie = new MovieController();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, movieID);
            preparedStatement.setObject(2, genreID);
            preparedStatement.setObject(3, movie.findByID(movieID));
            preparedStatement.setObject(4, genre.findByID(genreID));
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
