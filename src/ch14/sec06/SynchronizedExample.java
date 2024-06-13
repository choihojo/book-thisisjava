package ch14.sec06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SynchronizedExample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1Task user1Task = new User1Task();
        user1Task.setCalculator(calculator);

        Thread user1Thread = new Thread(user1Task);
        user1Thread.setName("User1Thread");
        user1Thread.start();

        User2Task user2Task = new User2Task();
        user2Task.setCalculator(calculator);

        Thread user2Thread = new Thread(user2Task);
        user2Thread.setName("User2Thread");
        user2Thread.start();
    }

}
