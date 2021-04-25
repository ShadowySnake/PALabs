package optionalPackage.daoClasses;

import java.sql.*;

public class PeopleDAO {
    public void create(String name, String jobType) {
        try {
            Connection connection = Database.getConnection();
            String sql = "insert into people values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,  1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, jobType);
            preparedStatement.executeUpdate();
            System.out.println("Check it out, a new person has been inserted!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select id from people where name like ?";
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
            String sql = "select name from people where id = ?";
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
