package calculator.model;

public class DecimalAdd implements StateTransition{
    private Calculator calculator;
    private String number;
    private String n;
    public DecimalAdd(Calculator calculator){
        this.calculator = calculator;
        this.number = Integer.toString((int)Math.round(this.calculator.getRight()))+".";
    }

    public double displayNumber() {
        return Double.parseDouble(this.number);
    }

    public void clearPressed() {
        this.number = "0";
        this.calculator.setState(new NumberMode(this.calculator));
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
        this.calculator.setRight(Double.parseDouble(this.number));
        this.calculator.setState(new EqualModeAdd(this.calculator));
    }

    public void decimalPressed() {
//        this.calculator.setLeft(Double.parseDouble(this.number));
//        this.calculator.setState(new DecimalMode(this.calculator));
    }
}
