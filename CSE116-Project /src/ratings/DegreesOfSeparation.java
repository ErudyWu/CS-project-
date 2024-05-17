package ratings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class DegreesOfSeparation {
    private HashMap<String, ArrayList<String>> adjacencyList;

    public DegreesOfSeparation(ArrayList<Movie> ary1) {// in here I need to create the graph
        this.adjacencyList = new HashMap<>();
        ArrayList<String> checking = new ArrayList<>();
        ArrayList<String> checked = new ArrayList<>();
        for (Movie m : ary1) {
            for (String actor : m.getCast()) {
                if (!checked.contains(actor)) {
                    checking.add(actor);
                    checked.add(actor);
                }
            }
        }
        //System.out.println("total actors:" + checking);
        for (String actor : checking) {
            this.adjacencyList.put(actor, new ArrayList<String>());
            for (Movie m : ary1) {
                if (m.getCast().contains(actor)) {
                    this.adjacencyList.get(actor).addAll(m.getCast());
                }
            }
        }
        this.adjacencyList = clean(this.adjacencyList);
        //System.out.println(this.adjacencyList);
    }

    public HashMap<String, ArrayList<String>> clean(HashMap<String, ArrayList<String>> hashMap) {
        HashMap<String, ArrayList<String>> out = new HashMap<>();
        ArrayList<String> check = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            ArrayList<String> ary1 = new ArrayList<>();
            for (String val : hashMap.get(key)) {
                if (!val.equals(key) && !ary1.contains(val)) {
                    ary1.add(val);
                }
            }
            out.put(key, ary1);
        }
        return out;
    }

    public int degreesOfSeparation(String from, String to) {
        if (this.adjacencyList == null){return -1;}
        else if(this.adjacencyList.get(from) == null){return -1;}
        else{
        ArrayList<String> CheckingList = new ArrayList<>();
        ArrayList<String> CheckedList = new ArrayList<>();
        CheckingList.addAll(this.adjacencyList.get(from));
        CheckedList.add(from);
        HashMap<String, Integer> output = new HashMap<>();
        for (String key : CheckingList) {
            output.put(key, 1);}
        //System.out.println("outputDict: " + output);
        if (from.equals(to)) {return 0;}
//        while (CheckedList.size() != this.adjacencyList.keySet().size()) {
        while (CheckingList.size() != 0){
            for (int x=0; x < CheckingList.size();x++) {
                if (!CheckedList.contains(CheckingList.get(x))) {
                    CheckedList.add(CheckingList.get(x));
                    //System.out.println("CheckedList: " + CheckedList);
                    }
                addNode(this.adjacencyList.get(CheckingList.get(x)), CheckingList, CheckedList, output);
                CheckingList.remove(CheckingList.get(x));
                //System.out.println("CheckingList after pop: " + CheckingList);
            }
        }if (!output.containsKey(to)){return -1;}
        else {
                System.out.println("distance from "+from + ": "+ output);
            return output.get(to);
        }}
}
public void addNode(ArrayList<String> tar, ArrayList<String> out,ArrayList<String> Checked,HashMap<String, Integer> hashMap){
        for (String s: tar){
            if (! out.contains(s) && !Checked.contains(s)){
                out.add(s);
                int x = hashMap.get(Checked.get(Checked.size()-1))+1;
                hashMap.put(s,x);
//                System.out.println("value: "+x);
//                System.out.println("CheckingList: "+out);
//                System.out.println("changedDict: " + hashMap);
            }
        }
}




















}
