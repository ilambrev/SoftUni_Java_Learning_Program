package E02DataTypesAndVariables;

import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int courses = 0;

        if (peopleNumber % elevatorCapacity == 0) {
            courses = peopleNumber / elevatorCapacity;
        } else {
            courses = peopleNumber / elevatorCapacity + 1;
        }
        System.out.println(courses);
    }
}