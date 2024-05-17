package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.FileReader;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ratings.FileReader.*;


public class TestFiles {
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
    public boolean compareTwoSongList(ArrayList<Song> ary1, ArrayList<Song> ary2) {
        if (ary1.size() != ary2.size()) {
            return false;
        } else {
            TestClasses1 TC1 = new TestClasses1();
            for (int x=0; x< ary1.size(); x++){
            if(findSongInArryList(ary1.get(x),ary2)){
                Song temp = getSongFromList(ary1.get(x),ary2);
                assertEquals(ary1.get(x).getTitle(),temp.getTitle());
                assertEquals(ary1.get(x).getArtist(),temp.getArtist());
                assertEquals(ary1.get(x).getSongID(), temp.getSongID());
                TestDataStructures1 TS1 = new TestDataStructures1();
                assertTrue(TS1.compareListsOfRatings(ary1.get(x).getRatings(),temp.getRatings()));
                }
            }
        }return true;
    }
    public boolean compareTwoAryList(ArrayList<String> ary1, ArrayList<String> ary2){
        if (ary1.size() != ary2.size()){
            return false;
        }else{
            for (int x=0; x< ary1.size(); x++){
                assertTrue(0==ary1.get(x).compareToIgnoreCase(ary2.get(x)));{
                }
            }
        }return true;
    }
    public static boolean checkMovieInList(ArrayList<Movie> list, String title){
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
    public boolean compareMovieArrayLists(ArrayList<Movie> ary1,ArrayList<Movie> ary2) {
        if (ary1.isEmpty() && ary2.isEmpty()){return true;}
        if (ary1.size() != ary2.size()) {
            return false;
        } else {
            TestDataStructures1 TS1= new TestDataStructures1();
            for(int x=0; x<ary1.size(); x++){
                if (checkMovieInList(ary2,ary1.get(x).getTitle())){
                    Movie movie_compare = findMovie(ary2,ary1.get(x).getTitle());
                assertEquals(0,ary1.get(x).getTitle().compareToIgnoreCase(movie_compare.getTitle()));
                assertTrue(compareTwoAryList(ary1.get(x).getCast(), movie_compare.getCast()));
                assertTrue(TS1.compareListsOfRatings(ary1.get(x).getRatings(),movie_compare.getRatings()));}
                else{return false;}
            }
        }return true;
    }
    @Test
    public void testing_for_diff_order(){
        Movie m1 = new Movie("a",new ArrayList<>(Arrays.asList("a")));
        Movie m2 = new Movie("b",new ArrayList<>(Arrays.asList("b")));
        Movie m3 = new Movie("c",new ArrayList<>(Arrays.asList("c")));
        ArrayList<Movie> ary1 = new ArrayList<>(Arrays.asList(m1,m2,m3));
        ArrayList<Movie> ary2 = new ArrayList<>(Arrays.asList(m1,m2,m3));
        assertTrue(compareMovieArrayLists(ary1,ary2));
    }
    @Test
    public void Testing_invalid_filename(){
        assertEquals(new ArrayList<Song>(),readSongs("data/hereIsNot"));
    }
    @Test
    public void Testing_artist_id_title_1(){
        ArrayList<Song> ary1 = new ArrayList<>();
        Song s1 = new Song("Nightcore","Ken Carson","6p1j9OP2IBdzR5tgtyJk10");
        Song s2 = new Song("Ric Flair Drip (with Metro Boomin)","Offset","7sO5G9EABYOXQKNPNiE9NR");
        Song s3 = new Song("Flashing Lights","Kanye West","5TRPicyLGbAF2LGBFbHGvO");
        Song s4 = new Song("Endless Fashion","Lil Uzi Vert","41bmnQZoDMQdDh5zyomtW7");
        Song s5 = new Song("Video Games","Lana Del Rey","24jvD83UgLmrdGjhWTFslY");
        Song s6 = new Song("Knockin' On Heaven's Door","Bob Dylan","6HSXNV0b4M4cLJ7ljgVVeh");
        Rating r1 =new Rating("221",5);
        Rating r2 =new Rating("243",5);
        Rating r3 =new Rating("40",5);
        Rating r4 =new Rating("38",2);
        Rating r5 =new Rating("223",3);
        Rating r6 =new Rating("46",5);
        Rating r7 =new Rating("66",4);
        Rating r8 =new Rating("117",5);
        Rating r9 =new Rating("248",5);
        Rating r10 =new Rating("219",3);
        Rating r11=new Rating("82",3);
        Rating r12=new Rating("66",3);
        Rating r13=new Rating("127",5);
        Rating r14=new Rating("66",3);
        Rating r15=new Rating("51",5);
        Rating r16=new Rating("89",3);
        s1.addRating(r1);
        s2.addRating(r2);
        s3.addRating(r3);s3.addRating(r4);s3.addRating(r5);s3.addRating(r6);s3.addRating(r7);
        s4.addRating(r8);s4.addRating(r9);s4.addRating(r10);s4.addRating(r11);s4.addRating(r12);
        s5.addRating(r13);s5.addRating(r14);
        s6.addRating(r15);s6.addRating(r16);
        ary1.add(s1);ary1.add(s2);ary1.add(s3);ary1.add(s4);ary1.add(s5);ary1.add(s6);
        assertTrue(compareTwoSongList(readSongs("data/songs.csv"),ary1));
    }
    @Test
    public void testing_readSong_properly(){
        ArrayList<Song> ary1 = readSongs("data/Song.csv");
        assertEquals("Nightcore",ary1.get(0).getTitle());
        assertEquals("Ken Carson",ary1.get(0).getArtist());
        assertEquals("6p1j9OP2IBdzR5tgtyJk10",ary1.get(0).getSongID());
    }
    @Test
    public void Testing_readSong_empty(){
        Song s1 = new Song("","","");
        Rating r1 = new Rating("",1);
        Rating r2 = new Rating("",1);
        Rating r3 = new Rating("",1);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        ArrayList<Song> ary1 = new ArrayList<>(Arrays.asList(s1));
        assertTrue(compareTwoSongList(readSongs("data/songempty.csv"),ary1));


    }
    @Test
    public void Testing_artist_id_title_2(){
        ArrayList<Song> ary1 = new ArrayList<>();
        Song s1 = new Song("Nightcore","Ken Carson","6p1j9OP2IBdzR5tgtyJk10");
        Song s2 = new Song("Ric Flair Drip (with Metro Boomin)","Offset","7sO5G9EABYOXQKNPNiE9NR");
        Song s3 = new Song("Flashing Lights","Kanye West","5TRPicyLGbAF2LGBFbHGvO");
        Song s4 = new Song("Endless Fashion","Lil Uzi Vert","41bmnQZoDMQdDh5zyomtW7");
        Rating r1 =new Rating("221",1);
        Rating r2 =new Rating("243",1);
        Rating r3 =new Rating("40",1);
        Rating r4 =new Rating("38",1);
        Rating r5 =new Rating("223",1);
        Rating r6 =new Rating("46",1);
        Rating r7 =new Rating("66",1);
        Rating r8 =new Rating("117",1);
        Rating r9 =new Rating("248",1);
        Rating r10 =new Rating("219",1);
        Rating r11=new Rating("82",1);
        Rating r12=new Rating("66",1);
        Rating r13=new Rating("127",1);
        Rating r14=new Rating("66",1);
        Rating r15=new Rating("51",1);
        Rating r16=new Rating("89",1);
        s1.addRating(r1);
        s2.addRating(r2);
        s3.addRating(r3);s3.addRating(r4);s3.addRating(r5);s3.addRating(r6);s3.addRating(r7);
        s4.addRating(r8);s4.addRating(r9);s4.addRating(r10);s4.addRating(r11);s4.addRating(r12);
        ary1.add(s1);ary1.add(s2);ary1.add(s3);ary1.add(s4);
        assertTrue(compareTwoSongList(readSongs("data/songs1.csv"),ary1));
    }
    @Test
    public void Testing_artist_id_title_3(){
        ArrayList<Song> ary1 = new ArrayList<>();
        Song s1 = new Song("Nightcore","Ken Carson","6p1j9OP2IBdzR5tgtyJk10");
        Song s2 = new Song("Ric Flair Drip (with Metro Boomin)","Offset","7sO5G9EABYOXQKNPNiE9NR");
        Song s3 = new Song("Flashing Lights","Kanye West","5TRPicyLGbAF2LGBFbHGvO");
        Song s5 = new Song("Video Games","Lana Del Rey","24jvD83UgLmrdGjhWTFslY");
        Song s6 = new Song("Knockin' On Heaven's Door","Bob Dylan","6HSXNV0b4M4cLJ7ljgVVeh");
        Rating r1 =new Rating("221",5);
        Rating r2 =new Rating("243",5);
        Rating r3 =new Rating("40",5);
        Rating r4 =new Rating("38",2);
        Rating r5 =new Rating("223",3);
        Rating r6 =new Rating("46",5);
        Rating r7 =new Rating("66",4);
        Rating r8 =new Rating("117",5);
        Rating r9 =new Rating("248",5);
        Rating r10 =new Rating("219",3);
        Rating r11=new Rating("82",3);
        Rating r12=new Rating("66",3);
        Rating r13=new Rating("127",5);
        Rating r14=new Rating("66",3);
        Rating r15=new Rating("51",5);
        Rating r16=new Rating("89",3);
        s1.addRating(r1);
        s2.addRating(r2);
        s3.addRating(r3);s3.addRating(r4);s3.addRating(r5);s3.addRating(r6);s3.addRating(r7);

        s5.addRating(r13);s5.addRating(r14);
        s6.addRating(r15);s6.addRating(r16);
        ary1.add(s1);ary1.add(s2);ary1.add(s3);ary1.add(s5);ary1.add(s6);
        assertTrue(compareTwoSongList(readSongs("data/songs2.csv"),ary1));
    }

    @Test
    public void Testing_readMovie_with_invalid_name(){
        assertEquals(new ArrayList<Movie>(),readMovies("data/hereIsNot"));
    }
    @Test
    public void Testing_readMovie_1(){
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Tom Hanks","Tim Allen"));
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Robin Williams","Jonathan Hyde","Kirsten Dunst"));
        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Steve Martin","Diane Keaton"));
        ArrayList<String> cast4 = new ArrayList<>(Arrays.asList("Al Pacino","Robert De Niro","Val Kilmer"));
        ArrayList<String> Cast5 = new ArrayList<>(Arrays.asList("a","b"));
        Movie m1 = new Movie("Toy Story",cast1);
        Movie m2 = new Movie("Jumanji",cast2);
        Movie m3 = new Movie("Father of the Bride Part II",cast3);
        Movie m4 = new Movie("Heathers",cast4);
        Movie m5 = new Movie("American Pie",Cast5);
        ArrayList<Movie> ary1 =new ArrayList<>(Arrays.asList(m1,m2,m3,m4,m5));
        assertTrue(compareMovieArrayLists(ary1,readMovies("data/movies1.csv")));
    }
    @Test
    public void Testing_readMovie_2(){
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Tom Hanks","Tim Allen"));
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Robin Williams","Jonathan Hyde","Kirsten Dunst"));
        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Steve Martin","Diane Keaton"));
        ArrayList<String> cast4 = new ArrayList<>(Arrays.asList("Al Pacino","Robert De Niro","Val Kilmer"));
        ArrayList<String> cast5 = new ArrayList<>(Arrays.asList("Pierce Brosnan","Sean Bean","Izabella Scorupco"));
        Movie m1 = new Movie("Toy Story",cast1);
        Movie m2 = new Movie("Jumanji",cast2);
        Movie m3 = new Movie("Father of the Bride Part II",cast3);
        Movie m4 = new Movie("Heat",cast4);
        Movie m5 = new Movie("GoldenEye",cast5);
        ArrayList<Movie> ary1 =new ArrayList<>(Arrays.asList(m1,m2,m3,m4,m5));
        assertTrue(compareMovieArrayLists(ary1,readMovies("data/movies2.csv")));
    }
    @Test
    public void Testing_readMovieRating_with_invalid_name() {
        assertEquals(new ArrayList<Movie>(),readMovieRatings(readMovies("data/movies2.csv"),"data/hereIsNot"));
    }
    @Test
    public void Testing_for_readMovieRating_with_unrated_movie(){
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Tom Hanks","Tim Allen"));
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Robin Williams","Jonathan Hyde","Kirsten Dunst"));
        ArrayList<String> cast3 = new ArrayList<>(Arrays.asList("Steve Martin","Diane Keaton"));
        ArrayList<String> cast4 = new ArrayList<>(Arrays.asList("Al Pacino","Robert De Niro","Val Kilmer"));
        ArrayList<String> Cast5 = new ArrayList<>(Arrays.asList("a","b"));
        Movie m1 = new Movie("Toy Story",cast1);
        Movie m2 = new Movie("Jumanji",cast2);
        Movie m3 = new Movie("Father of the Bride Part II",cast3);
        Movie m4 = new Movie("Heathers",cast4);
        Movie m5 = new Movie("American Pie",Cast5);
        Rating r1 = new Rating("4",5);
        Rating r2 = new Rating("15",4);
        m4.addRating(r1);m4.addRating(r2);
        Rating r3 = new Rating("1",4);
        Rating r4 = new Rating("4",4);
        Rating r6 = new Rating("15",4);
        m5.addRating(r3);m5.addRating(r4);m5.addRating(r6);
        ArrayList<Movie> ary1 =new ArrayList<>(Arrays.asList(m5,m4));
        assertTrue(compareMovieArrayLists(ary1,readMovieRatings(readMovies("data/movies1.csv"),"data/movie_ratings.csv")));
    }
}