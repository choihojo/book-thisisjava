package ch13.sec01;

public class Box<T extends Comparable<? super T>> {

    public T testMethod1(T param) {
        return param;
    }

    public <T> T testMethod2(T param) {
        return param;
    }

}
