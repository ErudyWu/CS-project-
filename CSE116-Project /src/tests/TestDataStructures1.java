package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import static org.junit.Assert.*;

public class TestDataStructures1 {

    public boolean compareListsOfRatings(LinkedListNode<Rating> LK1, LinkedListNode<Rating> LK2) {

//        System.out.println("Size: "+LK1.size());
//        System.out.println("Size: "+LK2.size());
        if(LK1 ==null && LK2 == null){return true;}
        else if(LK1 ==null || LK2 == null){return false;}

        else if (LK1.size() != LK2.size()){
//            System.out.println("go though else if ");
            return false;}
        else{
            int count =0;
            while(LK1 != null){
                assertEquals(LK1.getValue().getReviewerID().compareToIgnoreCase(LK2.getValue().getReviewerID()),0);
                assertEquals(LK1.getValue().getRating(),LK2.getValue().getRating());
                count += 1;
//                System.out.println("#"+count+"Compare "+"ID:"+LK1.getValue().getReviewerID()+" "+"rating:"+LK1.getValue().getRating());
//                System.out.println("#"+count+"Compare "+"ID:"+LK2.getValue().getReviewerID()+" "+"rating:"+LK2.getValue().getRating());
                LK1 = LK1.getNext();
                LK2 =LK2.getNext();}}return true; }

    @Test
    public void testing_averageRating_empty_rating2(){
        Song song1 =new Song("no rating","no rating","no rating");
        Rating r1 = new Rating("1",5);
        song1.addRating(r1);
        Reviewer rw1 =new Reviewer("1");
        song1.removeRatingByReviewer(rw1);
        Rating r2 = new Rating("1",5);
        song1.addRating(r1);
        Reviewer rw2 =new Reviewer("1");
        song1.removeRatingByReviewer(rw1);
        assertEquals(song1.averageRating(),0.0,0.01);}

    @Test

    public void testing_averageRating_valid_input(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
//        Rating r3 = new Rating("123",3);
        song1.addRating(r1);
        song1.addRating(r2);
//        song1.addRating(r3);
        assertEquals(song1.averageRating(),4.5,0.01);
    }
    @Test
    public void testing_averageRating_invalid_input(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("12",-1);
        Rating r5 = new Rating("123",-1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        assertEquals(song1.averageRating(),4.3,0.1);
    }
    @Test
    public void testing_averageRating_huge_input(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("12",1);
        Rating r5 = new Rating("123",1);
        Rating r11 = new Rating("1",5);
        Rating r22 = new Rating("12",4);
        Rating r33 = new Rating("123",4);
        Rating r44 = new Rating("12",1);
        Rating r55 = new Rating("123",1);
        Rating r111 = new Rating("1",5);
        Rating r222 = new Rating("12",4);
        Rating r333 = new Rating("123",4);
        Rating r444 = new Rating("12",1);
        Rating r555 = new Rating("123",1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        song1.addRating(r11);
        song1.addRating(r22);
        song1.addRating(r33);
        song1.addRating(r44);
        song1.addRating(r55);
        song1.addRating(r111);
        song1.addRating(r222);
        song1.addRating(r333);
        song1.addRating(r444);
        song1.addRating(r555);
        assertEquals(song1.averageRating(),3,0.001);}


    @Test
    public void testing_averageRating_one_valid(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        song1.addRating(r1);
        assertEquals(song1.averageRating(),5,0.01);
    }
    @Test
    public void testing_averageRating_all_invalid_input(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",-1);
        Rating r2 = new Rating("12",-5);
        Rating r3 = new Rating("123",0);
        Rating r4 = new Rating("12",-5);
        Rating r5 = new Rating("123",-1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        assertEquals(song1.averageRating(),0,0.1);}
    @Test
    public void testing_averageRating_one_invalid_input(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",-1);
        Rating r2 = new Rating("12",1);
        Rating r3 = new Rating("123",-1);
        Rating r4 = new Rating("12",1);
        Rating r5 = new Rating("123",1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        assertEquals(song1.averageRating(),1,0.1);
    }
    @Test
    public void testing_removeRatingByReviewer_middle(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("1234",-1);
        Rating r5 = new Rating("12345",-1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        LinkedListNode<Rating> LK1= song1.getRatings();
        LinkedListNode<Rating> LK2 =new LinkedListNode<Rating>(r5,null);
        LK2 = new LinkedListNode<Rating>(r4,LK2);
        LK2 = new LinkedListNode<Rating>(r3,LK2);
        LK2 = new LinkedListNode<Rating>(r1,LK2);
        Reviewer rw1 =new Reviewer("12");
        song1.removeRatingByReviewer(rw1);
        assertTrue(compareListsOfRatings(LK1, LK2));
    }

    @Test
    public void testing_removeRatingByReviewer_end(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("1234",-1);
        Rating r5 = new Rating("12345",-1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        LinkedListNode<Rating> LK1= song1.getRatings();
        LinkedListNode<Rating> LK2 =new LinkedListNode<Rating>(r4,null);
        LK2 = new LinkedListNode<Rating>(r3,LK2);
        LK2 = new LinkedListNode<Rating>(r2,LK2);
        LK2 = new LinkedListNode<Rating>(r1,LK2);
        Reviewer rw1 =new Reviewer("12345");
        song1.removeRatingByReviewer(rw1);
        assertTrue(compareListsOfRatings(LK1, LK2));
    }

    @Test
    public void testing_removeRatingByReviewer_head(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("1234",-1);
        Rating r5 = new Rating("12345",-1);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        LinkedListNode<Rating> LK2 =new LinkedListNode<Rating>(r5,null);
        LK2 = new LinkedListNode<Rating>(r4,LK2);
        LK2 = new LinkedListNode<Rating>(r3,LK2);
        LK2 = new LinkedListNode<Rating>(r2,LK2);
        Reviewer rw1 =new Reviewer("1");
        song1.removeRatingByReviewer(rw1);
        assertTrue(compareListsOfRatings(song1.getRatings(), LK2));
    }
    @Test
    public void testing_removeRatingByReviewer_null(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        LinkedListNode<Rating> LK2 = null;
        Reviewer rw1 =new Reviewer("1");
        song1.removeRatingByReviewer(rw1);
        assertTrue(compareListsOfRatings(song1.getRatings(), LK2));
    }
    @Test
    public void testing_removeRatingByReviewer_first(){
        Reviewer rw1 =new Reviewer("1");
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r1_ = new Rating("1",4);
        Rating r1_1 = new Rating("1",3);

        Rating r2 = new Rating("2",5);
        Rating r3 = new Rating("3",5);
        Rating r4 = new Rating("4",5);
        Rating r5 = new Rating("5",5);
        song1.addRating(r2);
        song1.addRating(r1_1); //this is the one I want to pop
        song1.addRating(r1_);
        song1.addRating(r1);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        LinkedListNode<Rating> LK2 =new LinkedListNode<Rating>(r5,null);
        LK2 = new LinkedListNode<Rating>(r4,LK2);
        LK2 = new LinkedListNode<Rating>(r3,LK2);
        LK2 = new LinkedListNode<Rating>(r1,LK2);
        LK2 = new LinkedListNode<Rating>(r1_,LK2);
        LK2 = new LinkedListNode<Rating>(r2,LK2);
        song1.removeRatingByReviewer(rw1);
        assertTrue(compareListsOfRatings(song1.getRatings(), LK2));
    }
    @Test
    public void Tetsing(){
        Song song1 =new Song("叹云兮","鞠婧炜","02.24");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("12",4);
        Rating r3 = new Rating("123",4);
        Rating r4 = new Rating("12",1);
        Rating r5 = new Rating("123",4);
        song1.addRating(r1);
        song1.addRating(r2);
        song1.addRating(r3);
        song1.addRating(r4);
        song1.addRating(r5);
        assertEquals(song1.bayesianAverageRating(3,3),3.375,0.1);
    }


}

