package ch14.sec06;

public class User1Task implements Runnable {

    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        System.out.println("Call User1Task");
        calculator.setMemory1(100);
    }

}
