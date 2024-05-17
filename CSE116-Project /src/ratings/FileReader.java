package ratings;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileReader {
    public static boolean findSongInArryList(Song s1,ArrayList<Song> list){
        if (list.isEmpty()){return false;}
        else{
            for (Song song:list){
                if(song.getTitle().equals(s1.getTitle())){
                    if (song.getSongID().equals(s1.getSongID())){
                        if(song.getArtist().equals(s1.getArtist())){
                            return true;
                        }
                    }
                }
            }
        }return false;
    }
    public static Song getSongFromList(Song s1, ArrayList<Song> list){
            for (Song song:list){
                if(song.getTitle().equals(s1.getTitle())){
                    if (song.getSongID().equals(s1.getSongID())){
                        if(song.getArtist().equals(s1.getArtist())){
                            return song;
                        }
                    }
                }
            }return s1;
    }
    public static ArrayList<Song> readSongs(String filename) {
        try {
            ArrayList<String> data = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            ArrayList<Song> playList = new ArrayList<>();
            for (int x=0;x <data.size();x++) {
                ArrayList<String> temp = new ArrayList<>(Arrays.asList(data.get(x).split(",")));
                Song s1 = new Song(temp.get(2), temp.get(1), temp.get(0));
                Rating r1 = new Rating(temp.get(3), Integer.parseInt(temp.get(4)));
                if (findSongInArryList(s1,playList)) {
                    getSongFromList(s1,playList).addRating(r1);
                } else {
                    s1.addRating((r1));
                    playList.add(s1);
                }
            }
            return playList;
        } catch (IOException ex) {
        }return new ArrayList<>();

    }

    public static ArrayList<Movie> readMovies(String filename){
        try {
            ArrayList<String> data = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            ArrayList<Movie> playList = new ArrayList<>();
            for (int x=0; x< data.size(); x++){
                ArrayList<String> temp = new ArrayList<>(Arrays.asList(data.get(x).split(",")));
                String title = temp.get(0);
                temp.remove(temp.get(0));
                Movie m1 =new Movie(title,temp);
                playList.add(m1);
            }
//            for (Movie movie: playList){
//                System.out.println("Movie:"+movie.getTitle());
//                System.out.println("the case member:"+movie.getCast());;}
            return playList;
        } catch (IOException ex) {
        }return new ArrayList<>();

    }
    public static boolean checkMovieInPlayList(ArrayList<Movie> list, String title){
        for(Movie m:list){
            if (m.getTitle().equals(title)){
                return true;
            }
        }return false;
    }
    public static Movie findMovie(ArrayList<Movie> list,String title){
        for(Movie m:list){
            if (m.getTitle().equals(title)){
                return m;
            }
        }return new Movie(title,new ArrayList<>());
    }
    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> List_M, String filename) {
        // we only add rating for the existing movie in both list and file.
        try {
            ArrayList<String> data = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            ArrayList<Movie> output = new ArrayList<>();
            for (String datum : data) {
                ArrayList<String> temp = new ArrayList<>(Arrays.asList(datum.split(",")));
                String M_title = temp.get(0);
                String RW_ID = temp.get(1);
                int rate = Integer.parseInt(temp.get(2));
                Rating r1 = new Rating(RW_ID, rate);
                if (checkMovieInPlayList(List_M, M_title)) {
                    if (checkMovieInPlayList(output, M_title)) {
                        findMovie(output, M_title).addRating(r1);
                    } else {
                        findMovie(List_M, M_title).addRating(r1);
                        output.add(findMovie(List_M, M_title));
                    }
                }
//                for (Movie movie: output){
//                    System.out.println("Movie:"+movie.getTitle());
//                    System.out.println("the case member:"+movie.getCast());
//                    System.out.println(movie.getRatings().getValue().getRating());
//                }
            }
            return output;
        } catch (IOException ex) {
        }return new ArrayList<>();
    }

}
