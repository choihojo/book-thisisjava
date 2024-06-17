package ch16.sec05;

import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class MethodReferenceExample2 {

    public static void main(String[] args) {
        Person person = new Person();
        person.ordering((a, b) -> a.compareToIgnoreCase(b));
        person.ordering(String::compareToIgnoreCase);
//        ObjectOutputStream out = new ObjectOutputStream();
//        PrintStream printStream = new PrintStream(ObjectOutputStream out);
        Integer[] test = new Integer[10];
    }

}
