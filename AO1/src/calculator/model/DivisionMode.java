package calculator.model;

public class DivisionMode implements StateTransition{
    private Calculator calculator;
    private double number1;
    private String number2 = "0";
    public DivisionMode(Calculator calculator){
        this.calculator = calculator;
        this.number1 = this.calculator.getLeft();
    }
    public double displayNumber() {
       return Double.parseDouble(this.number2);
    }

    public void clearPressed() {
        this.number2 = "0";
        this.calculator.setState(new NumberMode(this.calculator));
    }

    public void numberPressed(int number) {
        this.number2 += Integer.toString(number);
    }

    public void dividePressed() {
        this.calculator.setState(new DivisionMode(this.calculator));
    }

    public void multiplyPressed() {
        this.calculator.setState(new MultiplyMode(this.calculator));
    }

    public void subtractPressed() {
        this.calculator.setState(new SubtractMode(this.calculator));
    }

    public void addPressed() {
        this.calculator.setState(new AddMode(this.calculator));
    }

    public void equalsPressed() {
        this.calculator.setRight(Double.parseDouble(this.number2));
        this.calculator.setLeft(this.number1);
        this.calculator.setState(new EqualModeDivision(this.calculator));
    }

    public void decimalPressed() {
        this.calculator.setRight(Double.parseDouble(this.number2));
        this.calculator.setState(new DecimalDivision(this.calculator));
    }
}
