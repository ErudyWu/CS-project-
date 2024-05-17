package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import java.util.Objects;

import static org.junit.Assert.*;

public class TestClasses1 {


    public boolean compareSongs(Song o1, Song o2) {
        assertEquals(o1.getTitle().compareToIgnoreCase(o2.getTitle()),0);
        assertEquals(o1.getArtist().compareToIgnoreCase(o2.getArtist()),0);
        assertEquals(o1.getSongID().compareToIgnoreCase(o2.getSongID()),0);
        TestDataStructures1 TS1 = new TestDataStructures1();
        assertTrue(TS1.compareListsOfRatings(o1.getRatings(),o2.getRatings()));
        return true;}


    public boolean compareRatings(Rating r1, Rating r2) {
        assertEquals(r1.getRating(),r2.getRating());
        assertEquals(r1.getReviewerID(),r2.getReviewerID());
        return true;}


    public boolean compareReviewers(Reviewer rv1, Reviewer rv2) {
        assertEquals (rv1.getReviewerID(),rv2.getReviewerID());
        return true;}
    @Test
    public void testing_compareSongs_regular() {//failed
        Song o1 = new Song("hi world", "ego", "1314");
        Song o2 = new Song("hi world", "ego", "1314");
        assertTrue(compareSongs(o1,o2)== true);
        o1.setTitle("hey world");
        o1.setArtist("egoist");
        o1.setSongID("520");
        Song o3 =new Song("hey world","egoist","520");
        assertTrue(compareSongs(o1,o3)==true);

    }

    @Test
    public void testing_compareSongs_empty() {//failed
        Song o1 = new Song("", "", "");
        Song o2 = new Song("", "", "");
        assertTrue(compareSongs(o1, o2)==true);
    }



    @Test
    public void testing_compareRatings_right() {//failed
        Rating r1 = new Rating("8820",0);
        Rating r2 = new Rating("8820", -1);
        assertTrue(compareRatings(r1, r2)==true);
        Rating r3 =new Rating("520",4);
        r1.setReviewerID("520");
        r1.setRating(4);
        assertTrue(compareRatings(r1, r3)==true);

    }

    @Test
    public void testing_compareRatings_nagetive() {
        Rating r1 = new Rating("8820", -1);
        Rating r2 = new Rating("8820", -5);
        Rating r3 =new Rating("8820",-1);
        assertTrue(compareRatings(r1, r2)==true);
        r1.setRating(-4);
        assertTrue(compareRatings(r1, r3)==true);
    }
    @Test
    public void testing_compareRatings_huge() {
        Rating r1 = new Rating("8820", 888);
        Rating r2=new Rating("8820",-1);
        r1.setRating(9999999);
        assertTrue(compareRatings(r1, r2)==true);


    }



    @Test
    public void testing_compareRatings_empty() {
        Rating r1 = new Rating("", 0);
        Rating r2 = new Rating("", 0);
        assertTrue(compareRatings(r1, r2)== true);
    }

    @Test
    public void testing_compareReviewer_right() {
        Reviewer rv1 = new Reviewer("8820");
        Reviewer rv2 = new Reviewer("8820");
        assertTrue(compareReviewers(rv1, rv2)== true);
        rv1.setReviewerID("510");
        Reviewer rv3 = new Reviewer("510");
        assertTrue(compareReviewers(rv1, rv3)== true);
    }



    @Test
    public void testing_compareReviewer_empty() {
        Reviewer rv1 = new Reviewer("");
        Reviewer rv2 = new Reviewer("");
        assertTrue(compareReviewers(rv1, rv2)==true);
    }
    @Test
    public void testing_Reviewer_rateSong() {
        Reviewer rv1 = new Reviewer("12345");
        Rating r1 = rv1.rateSong(4);
        Rating r2 = new Rating("12345", 4);
        assertTrue(compareRatings(r1, r2)==true);
    }
    @Test
    public void testing_Reviewer_rateSong_naga() {
        Reviewer rv1 = new Reviewer("12345");
        Rating r1 = rv1.rateSong(-4);
        Rating r2 = new Rating("12345", -1);
        assertTrue(compareRatings(r1, r2)==true);
    }


}/// this is real one 
