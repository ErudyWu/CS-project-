package calculator.model;

public class Calculator {
    private StateTransition state = new NumberMode(this);
    private double left;
    private double right;
    public Calculator(){
    }
    public void setState(StateTransition state){
        this.state = state;
    }

    // Accessed by View. You should edit this method as you build functionality
    public double displayNumber() {
        return this.state.displayNumber();
    }

    public void clearPressed() {
        this.state.clearPressed();
    }

    public void numberPressed(int number) {
        this.state.numberPressed(number);
    }

    public void dividePressed() {
        this.state.dividePressed();
    }

    public void multiplyPressed() {
        this.state.multiplyPressed();
    }

    public void subtractPressed() {
        this.state.subtractPressed();
    }

    public void addPressed() {
        this.state.addPressed();
    }

    public void equalsPressed() {
        this.state.equalsPressed();
    }

    public void decimalPressed() {
        this.state.decimalPressed();
    }
    public double getLeft(){
        return this.left;
    }
    public void setLeft(double val){
        this.left = val;
    }
    public double getRight(){
        return this.right;
    }
    public void setRight(double val){
        this.right = val;
    }
}
