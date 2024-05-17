package ratings;

public class Rating {
    private String ID;
    private int rate;

    public Rating(String ID_p, int rate_p){
        this.ID=ID_p;
        if (rate_p>5){
            this.rate =-1;
        }else if(rate_p<=0){
            this.rate =-1;
        }else{
            this.rate =rate_p;
        }
    }
    public String getReviewerID(){
        return this.ID;
    }
    public void setReviewerID(String ID_p){
        this.ID=ID_p;
    }
    public int getRating(){
        return this.rate;
    }
    public void setRating(int rate_p){
        if (rate_p>5){
            this.rate =-1;
        }else if(rate_p<=0){
            this.rate =-1;
        }else{
            this.rate =rate_p;
        }

    }


}
