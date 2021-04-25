package optionalPackage.daoClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final ConnectionManager connectionManager = new ConnectionManager();
    private static Connection connection = null;

    public Database() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null)
            connection = connectionManager.createConnection();
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() throws SQLException, ClassNotFoundException {

        String delPeople = "DELETE FROM people WHERE id >= 1";
        String delMovies = "DELETE FROM optmovie WHERE id >= 1";
        Statement statement = getConnection().createStatement();
        statement.executeQuery(delMovies);
        statement.executeQuery(delPeople);
    }

    public static void commit() throws SQLException, ClassNotFoundException {
        if (!getConnection().getAutoCommit()) {
            Database.commit();
        }
    }
}
