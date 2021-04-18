package compulsoryPackage;

import java.sql.*;

public class GenresController {
    public void create(String name) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            String count = "select count(*) from genres";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql = "insert into genres values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            String sql = "select id from genres where name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String findByID(Integer id) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select name from genres where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return (String) result.getObject("name");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}