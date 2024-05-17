package tests;

import calculator.model.Calculator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCalculator {

    @Test
    public void testCalculator() {
        assertTrue(true);
    }

    @Test
    public void Testing_number_initial(){
        Calculator c1 = new Calculator();
        assertEquals(c1.displayNumber(),0.0,0.001);
    }
    @Test
    public void Testing_number_pressed_0(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        assertEquals(c1.displayNumber(),3.0,0.001);
    }
    @Test
    public void Testing_number_pressed_1(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.numberPressed(6);
        assertEquals(c1.displayNumber(),36.0,0.001);
    }
    @Test
    public void Testing_add(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.addPressed();
        c1.numberPressed(6);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),9.0,0.001);
    }
    @Test
    public void Testing_subtract(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.subtractPressed();
        c1.numberPressed(6);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),-3,0.001);
    }
    @Test
    public void Testing_times(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.multiplyPressed();
        c1.numberPressed(6);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),18,0.001);
    }
    @Test
    public void Testing_divided(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.dividePressed();
        c1.numberPressed(6);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),0.5,0.001);
    }
    @Test
    public void Testing_combine_1(){
        Calculator c1 = new Calculator();
        c1.numberPressed(2);
        c1.numberPressed(0);
        c1.addPressed();
        c1.numberPressed(1);
        c1.numberPressed(5);
        c1.equalsPressed();
        c1.dividePressed();
        c1.numberPressed(1);
        c1.numberPressed(0);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),3.5,0.001);
    }
    @Test
    public void Testing_combine_2(){
        Calculator c1 = new Calculator();
        c1.numberPressed(3);
        c1.addPressed();
        c1.numberPressed(4);
        c1.equalsPressed();
        c1.multiplyPressed();
        c1.numberPressed(2);
        c1.equalsPressed();
        assertEquals(c1.displayNumber(),14.0,0.001);
    }
    @Test
    public void Testing_clear(){
        Calculator c1 = new Calculator();
        c1.numberPressed(4);
        c1.clearPressed();
        assertEquals(c1.displayNumber(),0.0,0.001);
    }
    @Test
    public void Testing_decimal(){
        Calculator c1 = new Calculator();
        c1.numberPressed(1);
        c1.numberPressed(2);
        c1.decimalPressed();
        c1.decimalPressed();
        c1.numberPressed(5);
        c1.decimalPressed();
        c1.numberPressed(0);
        c1.decimalPressed();
        c1.numberPressed(5);
        System.out.println(c1.displayNumber());
        assertEquals(c1.displayNumber(),12.505,0.001);
    }
    @Test
    public void Testing_decimal_1(){
        Calculator c1 = new Calculator();
        c1.decimalPressed();
        c1.numberPressed(5);
        System.out.println(c1.displayNumber());
        assertEquals(c1.displayNumber(),.5,0.001);
    }
    @Test
    public void Testing_equal(){
        Calculator c1 = new Calculator();
        c1.numberPressed(8);
        c1.numberPressed(0);
        c1.subtractPressed();
        c1.numberPressed(1);
        c1.numberPressed(0);
        c1.equalsPressed();
        c1.equalsPressed();
        c1.equalsPressed();
        c1.equalsPressed();
        System.out.println(c1.displayNumber());
        assertEquals(c1.displayNumber(),40,0.001);
    }

}
