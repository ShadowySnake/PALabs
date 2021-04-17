package optionalPackage;

import java.sql.*;

public class GenresController
{
    public void create(Genres genre,Genres_Keeper keeper) throws SQLException
    {
        try
        {
            Connection connection = Database.getConnection();
            String count = "select count(*) from genres";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql="insert into genres values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            resultCount.next();
            genre.setId(resultCount.getInt(1) + 1);
            keeper.addGenre(genre);
            preparedStatement.setObject(1, genre.getId());
            preparedStatement.setObject(2, genre.getName());
            preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) throws SQLException
    {
        try
        {
            Connection connection = Database.getConnection();
            String sql = "select id from genres where name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}