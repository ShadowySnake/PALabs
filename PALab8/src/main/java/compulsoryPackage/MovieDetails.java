package compulsoryPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDetails {

    public void create(Integer movieID, Integer genreID) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            String sql = "insert into movie_genres values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, movieID);
            preparedStatement.setObject(2, genreID);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
