package ratings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary {

    public MediaLibrary() {
    }

    private ArrayList<Song> SongAry = new ArrayList<>();
    private ArrayList<Movie> MovieAry = new ArrayList<>();

    private ArrayList<Ratable> Library = new ArrayList<>();
    private Comparator<Integer> comparator;


    public void populateLibrary(String fileForSong, String fileForMovie, String fileForMovieRating) {
        this.SongAry = FileReader.readSongs(fileForSong);
        System.out.println("Song Size:"+this.SongAry.size());
        this.MovieAry = FileReader.readMovies(fileForMovie);
        System.out.println("Movie Size without rating:"+this.MovieAry.size());
        this.Library.addAll(this.SongAry);
        this.Library.addAll(FileReader.readMovieRatings(this.MovieAry, fileForMovieRating));
        System.out.println("Library size:"+this.Library.size());
    }

    public ArrayList<Ratable> topKRatables(int k) {
        if (k <=0){return new ArrayList<>();}
        ArrayList<Ratable> sorted_Library = new ArrayList<>();
        for (Ratable ratable : this.Library) {
            int location = 0;
            for (int y = 0; y < sorted_Library.size(); y++) {
                if (ratable.bayesianAverageRating(2, 3) <= sorted_Library.get(y).bayesianAverageRating(2, 3)) {
                    location++;
                }
            }
            sorted_Library.add(location, ratable);
        }
        if (k>=this.Library.size()){
            for (Ratable ratable : sorted_Library) {
                System.out.println(ratable.getTitle());
            }
        return sorted_Library;}
        else {
            ArrayList<Ratable> topKLibrary = new ArrayList<>();
            for (int x=0;x<k;x++){
                topKLibrary.add(sorted_Library.get(x));
                System.out.println(sorted_Library.get(x).getTitle());
            }
        return topKLibrary;
    }}
}