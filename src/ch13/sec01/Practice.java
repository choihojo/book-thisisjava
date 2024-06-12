package ch13.sec01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Practice<T> {

    private T test;

//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Box<String> box = new Box<String>();
//        Box<String>[] boxArr = new Box<>[10]; // Array creation with '<>' not allowed
        Box<String>[] boxArr = new Box[10]; // Unchecked assignment: 'ch13.sec01.Box[]' to 'ch13.sec01.Box<java.lang.String>[]'
        ArrayList<Box<String>> boxList = new ArrayList<Box<String>>();

        String test1 = box.testMethod1("테스트1");
        int test2 = box.testMethod2(2);
        Integer test3 = box.<Integer>testMethod2(3);

        List<?> list = new ArrayList<>();
        Collection test = null;

        BeverageUtil.sortWithWildcards(new ArrayList<Beverage>());
        BeverageUtil.sortWithWildcards(new ArrayList<Coke>());

        BeverageUtil.sortWithoutWildcards(new ArrayList<Beverage>());
        BeverageUtil.sortWithoutWildcards(new ArrayList<Coke>()); // reason: Incompatible equality constraint: Beverage and Coke
    }

}