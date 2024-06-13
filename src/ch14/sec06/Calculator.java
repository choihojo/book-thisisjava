package ch14.sec06;

public class Calculator {

    private int memory;

    public int getMemory() {
        return memory;
    }

    public synchronized void setMemory1(int memory) {
        System.out.println("Call setMemory1");
        this.memory = memory;
        try {
            System.out.println("Call setMemory1 sleep");
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }

    public void setMemory2(int memory) {
        System.out.println("Call setMemory2");
        synchronized (this) {
            this.memory = memory;
            try {
                System.out.println("Call setMemory2 sleep");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }

}
