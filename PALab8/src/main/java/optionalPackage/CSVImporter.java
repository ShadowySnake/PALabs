package optionalPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class CSVImporter {
    public void importMovies(Movies_Keeper keeper, MovieController mvController) {
        String path = "D:\\Java\\IMDb movies.csv";
        String line = "";
        int stocked = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                if (stocked == 31 || stocked == 17) {
                    line = reader.readLine();
                    ++stocked;
                }
                String[] columnVal = line.split(",");
                String date;
                String duration;
                String score;
                if (isDate(columnVal[4])) date = columnVal[4];
                else date = "2000-01-01";
                if (isNumber(columnVal[6])) duration = columnVal[6];
                else duration = "1";
                if (isNumber(columnVal[19])) score = columnVal[19];
                else score = "1.0";
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

    public boolean isNumber(String s) {
        if (s.equals("")) return false;

        String alphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ '";
        int posAt;
        for (posAt = 0; posAt < alphabet.length(); ++posAt) {
            if (s.startsWith(String.valueOf(alphabet.charAt(posAt)))) return false;
        }
        return true;
    }

    public boolean isDate(String s) {
        if (s.equals("")) return false;
        String alphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ '";
        int posAt;
        for (posAt = 0; posAt < alphabet.length(); ++posAt) {
            if (s.startsWith(String.valueOf(alphabet.charAt(posAt)))) return false;
        }
        return true;
    }
}
