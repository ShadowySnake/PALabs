package optionalPackage;

import java.sql.*;

public class MovieController {
    public void create(Movie movie, Movies_Keeper keeper) {
        try {
            Connection connection = Database.getConnection();
            String count = "select count(*) from movies";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql = "insert into movies values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultCount.next();
            movie.setId(resultCount.getInt(1) + 1);
            keeper.addMovie(movie);
            preparedStatement.setObject(1, movie.getId());
            preparedStatement.setObject(2, movie.getTitle());
            preparedStatement.setObject(3, movie.getReleaseDate());
            preparedStatement.setObject(4, movie.getDuration());
            preparedStatement.setObject(5, movie.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select id from movies where title like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, name);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}