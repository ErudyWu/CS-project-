package ratings;

public class Reviewer {
        private String ID;
        private Song song = new Song("我爱你","egoist","8820");

        public Reviewer(String ID_p){
            this.ID=ID_p;

        }
        public String getReviewerID(){
            return this.ID;
        }
        public void setReviewerID(String ID_p){
            this.ID =ID_p;
        }
        public Rating  rateSong(int rate){
           Rating r1 = new Rating(ID,rate);
           this.song.addRating(r1);
           return r1;
        }

    }// here has two major problem where the remove by reviewer doesn't work as expected and the get rating
// seems will reverse the order, which is not the way we inserted.

