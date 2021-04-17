package optionalPackage;

import java.sql.*;

public class PersonController {
    public void create(Persons person,Person_Keeper keeper) throws SQLException
    {
        try
        {
            keeper.addPerson(person);
            Connection connection = Database.getConnection();
            String sql="insert into persons values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, person.getId());
            preparedStatement.setObject(2, person.getName());
            preparedStatement.setObject(3, person.getJob());
            preparedStatement.setObject(4, person.getStarringIN());
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
            String sql = "select id from persons where person_name like ?";
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
}
