package ch15.sec02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorExample {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        List<Integer> list = new Vector<>();

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }
        };

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
        }

        int size = list.size();
        System.out.println("List 크기: " +  size);
    }

}
