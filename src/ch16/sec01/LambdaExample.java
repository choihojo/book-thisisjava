package ch16.sec01;

public class LambdaExample {

    public static class Test {
        void calculate(int x, int y) {
            System.out.println("Original: " + x + y);
        }
    }

    public static interface Test2 {
        void calculate(int x, int y);
    }

    public static void action(Test test) {
        int x = 10;
        int y = 4;
        test.calculate(x, y);
    }

    public static void action2(Test2 test) {
        int x = 10;
        int y = 4;
        test.calculate(x, y);
    }

    public static void main(String[] args) {
        action(new Test() {
            @Override
            void calculate(int x, int y) {
                System.out.println("Override: " + x + y);
            }
        });

//        action((x, y) -> {
//            System.out.println("Override: " + x + y);
//        }); // Target type of a lambda conversion must be an interface

        action2(new Test2() {
            @Override
            public void calculate(int x, int y) {
                System.out.println("Override2: " + x + y);
            }
        });
    }

}
