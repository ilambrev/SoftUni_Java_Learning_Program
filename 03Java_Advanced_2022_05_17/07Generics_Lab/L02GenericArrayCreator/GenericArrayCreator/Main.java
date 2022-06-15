package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);

        for (String s : strings) {
            System.out.println(s);
        }

        for (Integer n : integers) {
            System.out.println(n);
        }

    }
}