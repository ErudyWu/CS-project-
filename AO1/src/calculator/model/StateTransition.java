package calculator.model;

public interface StateTransition {
    public double displayNumber();

    public void clearPressed();

    public void numberPressed(int number);

    public void dividePressed();

    public void multiplyPressed();

    public void subtractPressed();

    public void addPressed();

    public void equalsPressed();

    public void decimalPressed();
}
