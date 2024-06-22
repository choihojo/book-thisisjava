package ch21.sec04;

public class Java21SwitchExample {

    private static void method1(Drawable drawable) {
        String result = switch (drawable) {
            case Shape s when s == Shape.LINE -> {
                System.out.println("Case: Shape");
                yield "선을 그립니다.";
            }
            case Shape s when s == Shape.TRIANGLE -> {
                System.out.println("Case: Triangle");
                yield "삼각형을 그립니다.";
            }
            case Shape s when s == Shape.RECTANGLE -> {
                System.out.println("Case: Rectangle");
                yield "사각형을 그립니다.";
            }
            case Image i when i == Image.JPEG -> {
                System.out.println("Case: JPEG");
                yield "JPEG를 그립니다.";
            }
            case Image i when i == Image.PNG -> {
                System.out.println("Case: PNG");
                yield "PNG를 그립니다.";
            }
//            case null, default -> {
//                System.out.println("Case: Null or Default");
//                yield "도형을 그리지 않습니다.";
//            }
            case null -> {
                System.out.println("Case: Null");
                yield "null 데이터를 입력했습니다.";
            }
            default -> {
                System.out.println("Case: Default");
                yield "도형을 그리지 않습니다.";
            }
        };
    }

    public static void main(String[] args) {
        method1(Shape.TRIANGLE);
        method1(null);
    }

}
