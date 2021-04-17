package optionalPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MovieDetails {

    public void create(Integer movieID, Integer genreID, Integer directorID,Movies_Keeper keeper) throws SQLException
    {
        try
        {
            Connection connection = Database.getConnection();
            String sql="insert into movie_details values(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            List<Movie> movies = keeper.getMoviesList();

            for (Movie movie : movies){
                if (movieID == movie.getId() ) {
                    movie.setGenreId(genreID);
                    movie.setDirectorId(directorID);
                }
            }

            preparedStatement.setObject(1, movieID);
            preparedStatement.setObject(2, genreID);
            preparedStatement.setObject(3,directorID);
            preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
