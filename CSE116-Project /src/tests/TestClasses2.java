package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestClasses2 {

    public boolean compareArrayListsIgnoreCase(ArrayList<String> ary1, ArrayList<String> ary2) {
        if(ary1.size() != ary2.size()){return false;}
        else{
            for(int i =0; i < ary1.size();i++){
                if(0!=ary1.get(i).compareToIgnoreCase(ary2.get(i))){return false;}
                assertEquals(0,ary1.get(i).compareToIgnoreCase(ary2.get(i)));}
            return true;}}

//    @Test
//    public void testing_getCast_normal(){
//        ArrayList<String> ary1 = new ArrayList<>();
//        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
//        Movie m1 = new Movie("Green Book",ary1);
//        ArrayList<String> ary2 = m1.getCast();
//        assertTrue(compareArrayListsIgnoreCase(ary2,ary1));
//    }
    @Test
    public void testing_getCast_diffCase(){
        ArrayList<String> ary1 = new ArrayList<>();
        ary1.add("AppLe");
        ary1.add("BANana");
        ary1.add("CheRry");
        ary1.add("OrANge");
        ArrayList<String> ary2 = new ArrayList<>();
        ary2.add("Apple");
        ary2.add("Banana");
        ary2.add("Cherry");
        ary2.add("Orange");
        Movie m1 = new Movie("Green Book",ary1);
//        String s1 ="AppLE"; String s2 = "apple";
        assertTrue(compareArrayListsIgnoreCase(ary2,m1.getCast()));
    }
    @Test
    public void testing_getCast_diffCase_and_order(){
        ArrayList<String> ary1 = new ArrayList<>();
        ary1.add("AppLe");
        ary1.add("BANana");
        ary1.add("CheRry");
        ary1.add("OrANge");
        ArrayList<String> ary2 = new ArrayList<>();
        ary2.add("Apple");
        ary2.add("Orange");
        ary2.add("Banana");
        ary2.add("Cherry");
        Movie m1 = new Movie("Green Book",ary1);
        assertFalse(compareArrayListsIgnoreCase(ary2,m1.getCast()));
    }
    @Test
    public void testing_getCast_one_case(){
        ArrayList<String> ary1 = new ArrayList<>();
        ary1.add("AppLe");
        ArrayList<String> ary2 = new ArrayList<>();
        ary2.add("Apple");
        Movie m1 = new Movie("Green Book",ary1);
//        String s1 ="AppLE"; String s2 = "apple";
        assertTrue(compareArrayListsIgnoreCase(ary2,m1.getCast()));
    }
    @Test
    public void testing_getCast_false(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "AppLe", "BANna", "CheRry", "OrANge");
        ArrayList<String> ary2 = new ArrayList<>();
        Collections.addAll(ary2, "Applee", "Bananaaaaaaaaaaaaa", "Cherryy", "OrangeE");
        Movie m1 = new Movie("Green Book",ary1);
//        String s1 ="AppLE"; String s2 = "apple";
        assertFalse(compareArrayListsIgnoreCase(ary2,m1.getCast()));
    }
    @Test
    public void testing_getCast_ALl_empty(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "", "", "", "");
        Movie m1 = new Movie("Green Book",ary1);
        ArrayList<String> ary2 = m1.getCast();
        assertTrue(compareArrayListsIgnoreCase(ary2,m1.getCast()));
    }
    @Test
    public void testing_getCast_oneCast_more_than_one_name(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Chris Pratt", "Zoe Saldana", "Dave Bautista");
        Movie m1 = new Movie("Green Book",ary1);
        ArrayList<String> ary2 = new ArrayList<>();
        Collections.addAll(ary2, "CHRIS pratt", "ZoE SalDANA", "dAVE bautistA");
        assertTrue(compareArrayListsIgnoreCase(m1.getCast(),ary2));}

    @Test
    public void testing_getCast_unnormal1(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "", "aa", "aaaa", "aaaa","A","AA","AAA");
        Movie m1 = new Movie("Green",ary1);
        ArrayList<String> ary2 = m1.getCast();
        ArrayList<String> ary3 = new ArrayList<>();
        Collections.addAll(ary3, "", "aa", "aaaa", "aaaa","A","AA","AAA");
        assertTrue(compareArrayListsIgnoreCase(ary2,ary3));
    }
    @Test
    public void testing_average_Song(){
        Song s1 = new Song("Dragon flame","Kirara","0318");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(2,3),3.667,0.001);
    }
    @Test
    public void testing_average_movie(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
        Movie s1 = new Movie("Dragon flame",ary1);
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(2,3),3.667,0.001);
    }



    @Test
    public void testing_average_zero_rating_zeroNum_S(){
        Song s1 = new Song("Dragon flame","Kirara","0318");
        assertEquals(s1.bayesianAverageRating(0,3),0,0.001);
    }
    @Test
    public void testing_average_zero_rating_zeroNum_M() {
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
        Movie s1 = new Movie("Dragon flame", ary1);
        assertEquals(s1.bayesianAverageRating(0, 3), 0, 0.001);
    }
    @Test
    public void testing_average_Song_zeroNum_S(){
        Song s1 = new Song("Dragon flame","Kirara","0318");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(0,3),4,0.001);
    }
    @Test
    public void testing_average_Song_zeroNum_M(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
        Movie s1 = new Movie("Dragon flame", ary1);
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(0,3),4,0.001);
    }
    @Test
    public void testing_average_zero_rating_nonzeroNum_S() {
        Song s1 = new Song("Dragon flame", "Kirara", "0318");
        assertEquals(s1.bayesianAverageRating(3, 3), 3, 0.001);
    }
    @Test
    public void testing_average_zero_rating_nonzeroNum_M() {
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
        Movie s1 = new Movie("Dragon flame", ary1);
        assertEquals(s1.bayesianAverageRating(3, 3), 3, 0.001);
    }
    @Test
    public void testing_average_Song_zeroNum_invaidVal_S(){
        Song s1 = new Song("Dragon flame","Kirara","0318");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(2,-3),0,0.001);}
    @Test
    public void testing_average_Song_zeroNum_invaidVal_M(){
        ArrayList<String> ary1 = new ArrayList<>();
        Collections.addAll(ary1, "Apple", "Banana", "Cherry", "Orange");
        Movie s1 = new Movie("Dragon flame", ary1);
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",4);
        Rating r4 = new Rating("4",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);s1.addRating(r4);
        assertEquals(s1.bayesianAverageRating(3,-2),0,0.001);}














    }

