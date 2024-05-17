package calculator.model;

public class DecimalMode implements StateTransition{
    private Calculator calculator;
    private String number;
    private String n;
    public DecimalMode(Calculator calculator){
        this.calculator = calculator;
        this.number = Integer.toString((int)Math.round(this.calculator.getLeft()))+".";
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

    }

    public void decimalPressed() {
//        this.calculator.setLeft(Double.parseDouble(this.number));
//        this.calculator.setState(new DecimalMode(this.calculator));
    }
}
