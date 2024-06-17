package ch17.sec06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FlatMappingExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("10, 20, 30", "40, 50");

        list.stream()
            .flatMapToInt(data -> {
                String[] strArr = data.split(",");
                int[] intArr = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    intArr[i] = Integer.parseInt(strArr[i].trim());
                }
                return Arrays.stream(intArr);
            })
            .forEach(System.out::println);

        System.out.println("=====");

        list.stream()
            .flatMap(data -> Arrays.stream(data.split(",")))
            .map(String::trim)
//            .map(string -> string.trim())
            .mapToInt(Integer::parseInt)
            .forEach(System.out::println);

        Function<String, String> function = string -> string.trim();
        Function<String, String> function2 = String::trim;
        String string = new String("111");
        string.concat("Test");
        Function<String, String> function3 = string::concat;

        Object obj = new Object();
        Function<String, Boolean> function4 = (a) -> obj.equals(a);
        Function<String, Boolean> function5 = obj::equals;
    }

}
