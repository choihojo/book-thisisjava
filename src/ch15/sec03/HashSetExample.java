package ch15.sec03;

import ch13.sec01.Box;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        Box<Integer> testBox = new Box<>();

        set.add(new Member(testBox, new String("최호조"), 10, Integer.valueOf(50)));
        set.add(new Member(testBox, new String("최호조"), 10, Integer.valueOf(50)));

        System.out.println("총 객체 수: " + set.size());
    }

}
