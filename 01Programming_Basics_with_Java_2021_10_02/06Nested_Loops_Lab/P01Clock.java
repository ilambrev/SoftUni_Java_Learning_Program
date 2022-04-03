package NestedLoops;

public class P01Clock {
    public static void main(String[] args) {

        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 59 ; j++) {
                System.out.printf("%d:%d%n", i, j);
            }
        }
    }
}