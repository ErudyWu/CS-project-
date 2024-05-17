package ratings;

import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Ratable {
    private String title;
    private Movie movie;
    private Song song;
    private LinkedListNode<Rating> LK;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title_p) {
        this.title = title_p;
    }
    public void addRating(Rating r1) {
        if (this.LK == null) {
            this.LK = new LinkedListNode<>(r1, null);
        } else {
            this.LK.append(r1);

        }
    }
    public void setRatings(LinkedListNode<Rating> r_p) {
        this.LK = r_p;
    }
    public double averageRating() {
        double sum = 0;
        double size = 0;
        if (this.LK == null){return 0;}
        ArrayList<Integer> ary = new ArrayList<>();
        ary.add(1);ary.add(2);ary.add(3);ary.add(4);ary.add(5);
        LinkedListNode<Rating> cur = this.LK;
        while (cur != null) {
            if (ary.contains(cur.getValue().getRating())){
                sum += cur.getValue().getRating();size += 1;}
            cur = cur.getNext();}
        if(size == 0){return 0;}
        else {return sum/size;}}

    public void removeRatingByReviewer(Reviewer rw)   {
        LinkedListNode<Rating> cur = this.LK; LinkedListNode<Rating> pre =null;
        if (cur == null)     {return;}
        else if(cur.getValue().getReviewerID().equals(rw.getReviewerID())) {
//            System.out.println("pop rating:"+"ID:"+this.LK.getValue().getReviewerID()+" "+"rating:"+this.LK.getValue().getRating());
            this.LK =this.LK.getNext();}
        else {
            while (true) {
                if (cur.getValue().getReviewerID().equals(rw.getReviewerID())) {
//                    System.out.println("pop rating:" + "ID:" + this.LK.getValue().getReviewerID() + " " + "rating:" + this.LK.getValue().getRating());
                    pre.setNext(cur.getNext());
                    break;
                } else {
                    pre = cur;
                    cur = cur.getNext();
                }
            }
        }}

    public LinkedListNode<Rating> getRatings() {
        if (this.LK == null) {
            return null;
        }else{
            return this.LK;
        }}


    //    public LinkedListNode<Rating> GetRatings() {
//        if (this.LK == null) {
//            return null;
//        } else if (this.LK.getNext() == null) {
//            return this.LK;
//
//        } else if (this.LK.getNext() != null) {
//            this.LK = this.LK.getNext();
//            GetRatings();
//        }
//        return null;
//    }

    public double bayesianAverageRating(int num, int value) {
        ArrayList<Integer> ary = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        if (!ary.contains(value)) {
            return 0.0;
        } else {
            if(this.averageRating() == 0){
                if(num == 0){return 0;}else{return value;}
            }else{
                if (num ==0){return this.averageRating();}
                else{
                    double sum = 0;
                    double size = 0;
                    LinkedListNode<Rating> cur = this.getRatings();
                    while(cur != null){
                        if (ary.contains(cur.getValue().getRating())){
                            sum += cur.getValue().getRating();size += 1;}
                        cur = cur.getNext();
                    } sum += num*value; size += num;
                    return sum/size;
                }}}}
}