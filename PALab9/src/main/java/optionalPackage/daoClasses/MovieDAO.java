package optionalPackage.daoClasses;

import java.sql.*;

public class MovieDAO {
    public void create(String name, Date date, Integer duration, Integer score) {
        try {
            Connection connection = Database.getConnection();
            String sql = "insert into optmovie values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,  1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, date);
            preparedStatement.setObject(4, duration);
            preparedStatement.setObject(5, score);
            preparedStatement.executeUpdate();
            System.out.println("Check it out, a new movie has been inserted!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select id from optmovie where title like ?";
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

    public String findByID(Integer id) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select title from optmovie where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getString(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
