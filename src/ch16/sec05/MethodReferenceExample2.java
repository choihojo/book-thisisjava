package ch16.sec05;

public class MethodReferenceExample2 {

    public static void main(String[] args) {
        Person person = new Person();
        person.ordering((a, b) -> a.compareToIgnoreCase(b));
        person.ordering(String::compareToIgnoreCase);
    }

}
