package ch14.sec06;

public class User2Task implements Runnable {

    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        System.out.println("Call User2Task");
        calculator.setMemory2(200);
    }

}
