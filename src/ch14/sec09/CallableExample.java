package ch14.sec09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) {
        // Callable 객체 생성
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("Call start");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                }
                // 작업 수행 후 결과 반환
                return 500;
            }
        };

        // FutureTask 생성
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // Thread 생성 및 시작
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // FutureTask에서 결과 가져오기
            System.out.println("Before get");
            Integer result = futureTask.get();
            System.out.println("After get");
            System.out.println("Result from FutureTask: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main end");
    }

}
