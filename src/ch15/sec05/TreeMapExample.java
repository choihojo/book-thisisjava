package ch15.sec05;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Entry<String, Integer> entry = null;
        entry = treeMap.firstEntry();
        System.out.println("First: " + entry);
        entry = treeMap.lastEntry();
        System.out.println("Last: " + entry);
        entry = treeMap.lowerEntry("ever");
        System.out.println("Before ever: " + entry);

        NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
        Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        for (Entry<String, Integer> entry2 : descendingEntrySet) {
            System.out.println(entry2.getKey() + ": " + entry2.getValue());
        }

        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", false);
        Set<Entry<String, Integer>> rangeEntrySet = rangeMap.entrySet();
        for (Entry<String, Integer> e : rangeEntrySet) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }

}
