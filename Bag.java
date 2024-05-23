import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Bag {
    private ArrayList<Integer> ary = new ArrayList<>();
    public int findItems(int num){
        if (this.ary.isEmpty()){
            this.ary.add(num);
            return num;
        }int sum = 0;
        for (int x : this.ary){
            sum += x;
        }this.ary.add(num-sum);
        return num-sum;
    }
    public static void main(String[] testing){
        Bag b1 = new Bag();
        System.out.println("第一个箱子有"+b1.findItems(40)+"件");
        System.out.println("第二个箱子有"+b1.findItems(64)+"件");
        System.out.println("第三个箱子有"+b1.findItems(69)+"件");
        System.out.println("第四个箱子有"+b1.findItems(86)+"件");
        System.out.println("第五个箱子有"+b1.findItems(107)+"件");



    }
}
