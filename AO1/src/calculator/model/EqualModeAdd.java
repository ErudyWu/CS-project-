package calculator.model;

public class EqualModeAdd implements StateTransition{
    private Calculator calculator;
    private double number1;
    private double number2;
    private String number;
    public EqualModeAdd(Calculator calculator){
        this.calculator = calculator;
        this.number1 = this.calculator.getLeft();
        this.number2 = this.calculator.getRight();
        this.number  = Double.toString(this.number1+this.number2);
    }
    public double displayNumber() {
        return Double.parseDouble(this.number);
    }

    public void clearPressed() {
        this.number = "0";
        this.calculator.setState(new NumberMode(this.calculator));
    }

    public void numberPressed(int number) {
        this.calculator.setState(new NumberMode(this.calculator));
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
        this.number = Double.toString(Double.parseDouble(this.number)+this.number2);
        this.calculator.setLeft(Double.parseDouble(this.number));
    }

    public void decimalPressed() {
        this.calculator.setLeft(Double.parseDouble(this.number));
        this.calculator.setState(new DecimalMode(this.calculator));
    }
}
