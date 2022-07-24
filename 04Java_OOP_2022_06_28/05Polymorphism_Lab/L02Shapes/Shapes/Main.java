package Shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(3.3, 4.4);
        Shape circle = new Circle(5.5);

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());

        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

    }
}