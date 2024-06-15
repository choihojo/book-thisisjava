package ch15.sec05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(2);

        for (Integer e : treeSet) {
            System.out.println(e);
        }

        System.out.println("가장 작은 수: " + treeSet.first());
        System.out.println("가장 큰 수: " + treeSet.last());
        System.out.println("3점 아래 점수: " + treeSet.lower(3));
        System.out.println("3점 위 점수: " + treeSet.higher(3));
        System.out.println("3점이거나 바로 아래의 점수: " + treeSet.floor(3));
        System.out.println("3점이거나 바로 위의 점수: " + treeSet.ceiling(3));

        NavigableSet<Integer> navigableSet = treeSet.descendingSet();
        for (Integer e : navigableSet) {
            System.out.println(e);
        }

        System.out.println("=====");

        NavigableSet<Integer> navigableRangeSet = treeSet.headSet(3, true);
        for (Integer e : navigableRangeSet) {
            System.out.println(e);
        }

    }

}
