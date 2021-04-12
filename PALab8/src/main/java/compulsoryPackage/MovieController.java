package compulsoryPackage;

import java.sql.*;

public class MovieController
{
    public void create(String name, Date date, Integer duration, Integer score)
    {
        try
        {
            Connection connection=Database.getConnection();
            String count = "select count(*) from movies";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql="insert into movies values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1)+1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, date);
            preparedStatement.setObject(4, duration);
            preparedStatement.setObject(5, score);
            preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name)
    {
        try
        {
            Connection connection = Database.getConnection();
            String sql = "select id from movies where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, name);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String findByID(Integer id)
    {
        try
        {
            Connection connection = Database.getConnection();
            String sql = "select title from movies where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getString(1);
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}