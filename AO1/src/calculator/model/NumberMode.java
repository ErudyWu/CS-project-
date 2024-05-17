package calculator.model;

public class NumberMode  implements StateTransition{
private Calculator calculator;
private String number = "0";
public NumberMode(Calculator calculator){
    this.calculator = calculator;
}
    public double displayNumber() {
        return Double.parseDouble(this.number);
    }

    public void clearPressed() {
        this.number = "0";
    }

    public void numberPressed(int number) {
        this.number += Integer.toString(number);
    }

    public void dividePressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new DivisionMode(this.calculator));
    }

    public void multiplyPressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new MultiplyMode(this.calculator));
    }

    public void subtractPressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new SubtractMode(this.calculator));
    }

    public void addPressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new AddMode(this.calculator));
    }

    public void equalsPressed() {
        // do nothing
    }

    public void decimalPressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new DecimalMode(this.calculator));
    }
}
