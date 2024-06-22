package ch21.sec06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ThreadInterruptExample {
    public static void main(String[] args) {
        // 새로운 스레드 생성
        Thread readingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter something: ");
                    String input = reader.readLine(); // 사용자 입력 대기
                    System.out.println("You entered: " + input);
                } catch (Exception e) {
                    System.out.println("IOException occurred: " + e.getMessage());
                }
            }
        });

        System.out.println("Thread Start");
        // 새로운 스레드 시작
        readingThread.start();

        // 메인 스레드가 5초 동안 대기
        try {
            System.out.println("Thread Sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted!");
        }

        System.out.println("Thread Interrupt");
        // 새로운 스레드를 interrupt
        // interrupt를 한다고 반드시 해당 스레드가 중지되는 것은 아니다.
        // readLine()과 같이 blocking 메서드의 경우 interrupt가 먹히지 않는다.
        readingThread.interrupt();

        // 스레드가 종료될 때까지 대기
        try {
            System.out.println("Thread Join");
            readingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted during join!");
        }

        System.out.println("Main thread finished.");
    }
}