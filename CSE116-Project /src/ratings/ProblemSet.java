package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        if (!numbers.isEmpty()) {
            int len = numbers.size();
            double sum = 0;
            for (double number:numbers) {
                sum += number;
            }
            return sum / len;

        } else {
            return 0.0;
        }
    }
    // TODO: Implement this method to return the average of all the numbers in the input ArrayList
    //       If the ArrayList is empty, return 0.0
    //
    // Examples
    // [1.0,2.0,3.0] returns 2.0
    // [-5.0,5.0] returns 0.0
    // [6.5,6.5,8.5,8.5] returns 7.5
    // [] returns 0.0


    public static int sumOfDigits(int digit) {
        int out = 0;
        if (digit < 0) {
            digit = -digit;
        }
        for (int x = 1000000000; x > 0; x = x / 10) {
            out += digit / x;
            if (out != 0) {
                digit = digit - (digit / x) * x;
            }
        }
        return out;
    }

    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
    public static String bestKey(HashMap<String, Integer> dic1) {
        if (!dic1.isEmpty()) {
                double check = -999999999;
                String out = "";
                for (String key : dic1.keySet()) {
                    if (dic1.get(key) >= check) {
                        out = key;
                        check = dic1.get(key);
                    }
                }
            return out;
        } else {
            return "";
        }
    }




    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""

    //Here start the task 2



























}