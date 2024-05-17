package ratings;

import java.util.ArrayList;

public class Movie extends Ratable{
    private ArrayList<String> castMembers;
    public Movie(String title_p, ArrayList<String> cast_members_p){
            this.setTitle(title_p);
            this.castMembers = cast_members_p;
    }
    public ArrayList<String> getCast(){
        ArrayList<String> Ary =new ArrayList<>();
        for (int i=0; i<this.castMembers.size();i++){
            Ary.add(this.castMembers.get(i));
        }
        return Ary;
    }
}
