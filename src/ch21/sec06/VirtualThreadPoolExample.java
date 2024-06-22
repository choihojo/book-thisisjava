package ch21.sec06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadPoolExample {

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            try {
                long sum = 0;
                for (int i = 1; i <= 1_000; i++) {
                    sum += i;
                }
                // Blocking I/O: 매 작업마다 10ms 걸린다고 가정
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                System.out.println("Interrupt 요청 발생");
                return;
            }
        };

        int taskNum = 10_000;

        // 플랫폼 스레드 100개를 풀링해서 사용하는 스레드 풀 생성
        ExecutorService threadExecutor = Executors.newFixedThreadPool(100);

        // 작업 처리 요청
        work(taskNum, task, threadExecutor);

//        Thread.sleep(10_000);

        // 가상 스레드를 사용하는 스레드 풀 생성
        ExecutorService  virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();

        // 작업 처리 요청
        work(taskNum, task, virtualThreadExecutor);
    }

    private static void work(int taskNum, Runnable task, ExecutorService executorService) throws Exception {
        long start = System.nanoTime();

        // Java 19 이후에는 ExecutorService가 AutoClosable을 구현하고 있기 때문에 try-with-resources 구문을 활용할 수 있다.
        // 이렇게 활용하면 shutdown()이 finally에 생략되어있다고 볼 수 있다.
//        try (executorService) {
            for (int cnt = 0; cnt < taskNum; cnt++) {
                executorService.execute(task);
//                executorService.shutdownNow();
            }
//        }

        executorService.shutdownNow();
//        executorService.shutdown();
//        System.out.println(executorService.awaitTermination(1, TimeUnit.SECONDS));

        long end = System.nanoTime();
        long workTime = end - start;
        System.out.println("작업 처리 시간: " + workTime + "ns");
    }

}
