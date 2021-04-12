package compulsoryPackage;

import java.sql.*;

public class Database
{
    private static Connection connection = null;
    private static final ConnectionManager connectionManager = new ConnectionManager();

    public Database() { }

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        if(connection == null)
            connection = connectionManager.createConnection();
        return connection;
    }

    public static void closeConnection() throws SQLException
    {
        connection.close();
    }

    public static void rollback() throws SQLException, ClassNotFoundException
    {

        String delGenres = "DELETE FROM genres WHERE id >= 1";
        String delMovies = "DELETE FROM movies WHERE id >= 1";
        String delMoviesGenres = "DELETE FROM movie_genres WHERE movie_id >= 1";
        Statement statement = getConnection().createStatement();
        statement.executeQuery(delMoviesGenres);
        statement.executeQuery(delMovies);
        statement.executeQuery(delGenres);
    }
    public static void commit() throws SQLException, ClassNotFoundException {
        if(!getConnection().getAutoCommit()){
            Database.commit();
        }
    }
}