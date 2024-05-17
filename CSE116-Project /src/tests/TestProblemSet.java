package tests;

import org.junit.Test;
import ratings.ProblemSet;
import ratings.Song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// TODO: Write testing for all 3 methods of the ratings.ProblemSet class
public class TestProblemSet {
    @Test//problem 1 finished lmao
    public void testing_average_positive() {
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(5.0);
        list2.add(1.0);
        list2.add(2.0);
        list2.add(6.0);

        assertEquals(3.5, ProblemSet.average(list2), 0.001);
    }
@Test
public void testing_average_nagetive(){
    ArrayList<Double> list3 = new ArrayList<>(Arrays.asList(-2.0,-3.0,-7.0,-90.0,-100.0));
    assertEquals(-40.4, ProblemSet.average(list3), 0.001);
}
    @Test
    public void testing_average_empty(){
        ArrayList<Double> list3 = new ArrayList<>();
        assertEquals(0.0, ProblemSet.average(list3), 0.001);
    }
    @Test
    public void testing_average_zero(){
        ArrayList<Double> list3 = new ArrayList<>();
        list3.add(5.0);
        assertEquals(5.0, ProblemSet.average(list3), 0.001);
    }

    @Test // finished problem 2
    public void testing_sumOfDigits() {
        assertTrue(ProblemSet.sumOfDigits(123)== 6);
        assertTrue(ProblemSet.sumOfDigits(57)== 12);
        assertTrue(ProblemSet.sumOfDigits(-36)== 9);
    }
    @Test
    public void testing_bestKey_positive(){
        HashMap<String,Integer> dic1 = new HashMap<>();
        dic1.put("CSE",100);
        dic1.put("MTH",90);
        dic1.put("MGT",10);
        dic1.put("CS",100);
        dic1.put("MT",90);
        dic1.put("MG",10);
        dic1.put("C",100);
        dic1.put("M",90);
        dic1.put("G",10);
        assertTrue(ProblemSet.bestKey(dic1)=="CSE"||ProblemSet.bestKey(dic1)=="CS"||ProblemSet.bestKey(dic1)=="C");
        HashMap<String,Integer> dic2 = new HashMap<>();
        dic2.put("cat",5);
        dic2.put("dog",5);
        dic2.put("fox",3);
        assertTrue(ProblemSet.bestKey(dic2) == "dog" ||ProblemSet.bestKey(dic2) == "cat");


    }
    @Test
    public void testing_bestKey_nagetive() {
        HashMap<String, Integer> dic2 = new HashMap<>();
        dic2.put("cat", -3);
        dic2.put("dog", -7);
        dic2.put("fox", -6);
        assertTrue(ProblemSet.bestKey(dic2) == "cat");
    }
    @Test
    public void testing_bestKey_empty(){
        HashMap<String,Integer> dic3 = new HashMap<>();
        assertTrue(ProblemSet.bestKey(dic3) == "");
    }
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""
}
//it could save when you close it 
