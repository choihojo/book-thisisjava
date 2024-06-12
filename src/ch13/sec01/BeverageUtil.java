package ch13.sec01;

import java.util.List;

public class BeverageUtil {

    public static <T extends Comparable<? super T>> void sortWithWildcards(List<T> list) {
        list.sort(null);
    }

    public static <T extends Comparable<T>> void sortWithoutWildcards(List<T> list) {
        list.sort(null);
    }

}
