package optionalPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class CSVImporter {
    /**
     *
     * @param keeper is the Keeper for movies, that keeps track of what movies are existent
     * @param mvController the controller for inserting or searching for a movie in a database
     */
    public void importMovies(Movies_Keeper keeper, MovieController mvController) {
        String path = "D:\\Java\\IMDb movies.csv"; // i take the path for the csv file i want to open
        String line = ""; // this is an argument that later will read a whole line
        int stocked = 0; // keeps track of how many new inserts have been achieved

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine(); // a buffered reader is created that knows to open the csv file

            while ((line = reader.readLine()) != null) {
                if (stocked == 31 || stocked == 17) {
                    line = reader.readLine();
                    ++stocked;
                }
                String[] columnVal = line.split(",");
                // i separate the line in multiple arguments, each argument will be a column from sql table
                String date;
                String duration;
                String score;
                if (isNumber(columnVal[4])) date = columnVal[4];
                else date = "2000-01-01";
                if (isNumber(columnVal[6])) duration = columnVal[6];
                else duration = "1";
                if (isNumber(columnVal[19])) score = columnVal[19];
                else score = "1.0";
                // because the csv is a bit corrupted or it is made in a bad way, sometimes the columns don't have
                // the expected values such as a date or a number

                 mvController.create(new Movie(columnVal[1], Date.valueOf(date),
                       Integer.parseInt(duration),(int)Double.parseDouble(score)), keeper);

                //System.out.println(date + " " + duration + " " + score + " and being the " + stocked);
                if (stocked == 50) break;
                else stocked++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function checks if a string ( received as an argument ) is a number or not
     * @param s is the string for which a check is made
     * @return true if the string is only a number string and false otherwise
     */
    public boolean isNumber(String s) {
        if (s.equals("")) return false;

        String alphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ '";
        int posAt;
        for (posAt = 0; posAt < alphabet.length(); ++posAt) {
            if (s.startsWith(String.valueOf(alphabet.charAt(posAt)))) return false;
        }
        return true;
    }
}
