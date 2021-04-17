package optionalPackage;

import java.util.ArrayList;
import java.util.List;

public class Genres_Keeper {
    private List<Genres> genresList;

    public Genres_Keeper(){
        this.genresList = new ArrayList<>();
    }

    public List<Genres> getGenresList() {
        return genresList;
    }

    public void addGenre(Genres genre){
        this.genresList.add(genre);
    }

    public String findById(int id){
        for (Genres genre : genresList){
            if (genre.getId() == id) return genre.getName();
        }
        return "";
    }
}
